package com.example.academy_movie.ui.main.fragments.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.academy_movie.data.model.SearchMovieResponse
import com.example.academy_movie.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso
import javax.inject.Inject

class SimilarMoviesAdapter @Inject constructor() :RecyclerView.Adapter<SimilarMoviesAdapter.SimilarMoviesViewHolder>() {

    //binding
    private lateinit var binding :ItemMovieBinding

    inner class SimilarMoviesViewHolder :RecyclerView.ViewHolder(binding.root){

        fun bindViews(item :SearchMovieResponse.Search){
            binding.apply {
                Picasso.get().load(item.poster).into(itemImage)
                itemMovieNameTxt.text = item.title
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMoviesViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SimilarMoviesViewHolder()
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: SimilarMoviesViewHolder, position: Int) {
        holder.bindViews(differ.currentList[position])
    }

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

    val differ = AsyncListDiffer(this, differCallback)

}