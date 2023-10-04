package com.example.academy_movie.ui.main.fragments.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.academy_movie.databinding.FragmentDetailBinding
import com.example.academy_movie.ui.main.fragments.detail.adapter.SimilarMoviesAdapter
import com.example.academy_movie.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {

    //binding
    private lateinit var binding: FragmentDetailBinding

    //others
    private val detailArgs: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModels()

    @Inject
    lateinit var similarMoviesAdapter: SimilarMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData(detailArgs.movieId)
        showLoading()
        loadSimilarMoviesData()
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun loadData(i: String) {
        detailViewModel.getMovieDetailViewModel(i)
        binding.apply {
            detailViewModel.movieDetail.observe(viewLifecycleOwner) {
                movieTimeTxt.text = it.runtime
                movieViewerTxt.text = it.imdbVotes?.substring(0, 4)
                movieNameEnglish.text = it.title
                movieShortDescription.text = it.plot
                movieImdbRateTxt.text = "IMDB : ${it.imdbRating}"
                movieLongDescription.text = it.plot
                Picasso.get().load(it.poster).into(detailMovieImage)
                Picasso.get().load(it.poster).into(movieImage)
            }
        }
    }

    private fun showLoading() {
        binding.apply {
            detailViewModel.loading.observe(viewLifecycleOwner) {
                if (it) {
                    detailNestedScrollView.visibility = View.GONE
                    detailLoading.visibility = View.VISIBLE
                } else {
                    detailNestedScrollView.visibility = View.VISIBLE
                    detailLoading.visibility = View.GONE
                }
            }
        }
    }

    private fun loadSimilarMoviesData() {
        detailViewModel.similarMovies.observe(viewLifecycleOwner) {
            binding.similarMovieRec.apply {
                similarMoviesAdapter.differ.submitList(it.search)
                adapter = similarMoviesAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
            }
        }
    }


}