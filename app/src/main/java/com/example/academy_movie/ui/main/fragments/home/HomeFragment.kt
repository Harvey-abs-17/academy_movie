package com.example.academy_movie.ui.main.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.academy_movie.R
import com.example.academy_movie.databinding.FragmentHomeBinding
import com.example.academy_movie.ui.main.fragments.home.adapter.HomeMovieAdapter
import com.example.academy_movie.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    //binding
    private lateinit var binding: FragmentHomeBinding

    //other
    private val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var homeMovieAdapter: HomeMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.activeLoading()
        loadMovieRec()
        showLoading()
    }

    private fun loadMovieRec() {
        lifecycleScope.launch {
            homeViewModel.movieList.collect {
                homeMovieAdapter.submitData(it)
            }
        }
        binding.homeMovieRec.apply {
            this.adapter = homeMovieAdapter
            this.layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
    private fun showLoading(){
        binding.apply {
            homeViewModel.loading.observe(viewLifecycleOwner){
                if(it){
                    mainContainer.visibility = View.GONE
                    homeLoading.visibility = View.VISIBLE
                }else{
                    mainContainer.visibility = View.VISIBLE
                    homeLoading.visibility = View.GONE
                }
            }
        }
    }


}