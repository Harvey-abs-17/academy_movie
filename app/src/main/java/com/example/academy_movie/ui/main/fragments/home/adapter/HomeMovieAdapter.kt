package com.example.academy_movie.ui.main.fragments.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.academy_movie.data.model.SearchMovieResponse
import com.example.academy_movie.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso
import javax.inject.Inject

class HomeMovieAdapter @Inject constructor() :PagingDataAdapter<SearchMovieResponse.Search, HomeMovieAdapter.HomeMovieViewHolder>(differCallback) {

    //binding
    private lateinit var binding :ItemMovieBinding

    inner class HomeMovieViewHolder :RecyclerView.ViewHolder(binding.root){

        fun bindViews( item :SearchMovieResponse.Search ){
            binding.apply {
                Picasso.get().load(item.poster).into(itemImage)
                itemMovieNameTxt.text = item.title
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(item.imdbID!!)
                    }
                }
            }
        }

    }

    override fun onBindViewHolder(holder: HomeMovieViewHolder, position: Int) {
        holder.bindViews(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeMovieViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeMovieViewHolder()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    private var onItemClickListener :((movie_id :String) -> Unit)? = null
    fun itemClickListener( listener :(movie_id :String) -> Unit ){
        onItemClickListener = listener
    }

    companion object{

        private val differCallback = object :DiffUtil.ItemCallback<SearchMovieResponse.Search>(){
            override fun areItemsTheSame(
                oldItem: SearchMovieResponse.Search,
                newItem: SearchMovieResponse.Search
            ): Boolean {
                return oldItem.imdbID == newItem.imdbID
            }

            override fun areContentsTheSame(
                oldItem: SearchMovieResponse.Search,
                newItem: SearchMovieResponse.Search
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}