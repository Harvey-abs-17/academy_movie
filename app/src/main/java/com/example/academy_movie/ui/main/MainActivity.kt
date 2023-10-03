package com.example.academy_movie.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.academy_movie.R
import com.example.academy_movie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //binding
    private lateinit var binding :ActivityMainBinding
    //others
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding.root )

        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment


    }
}