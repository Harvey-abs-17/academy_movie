package com.example.academy_movie.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import com.example.academy_movie.R
import com.example.academy_movie.databinding.ActivityMainBinding
import com.example.academy_movie.ui.main.fragments.CheckConnection
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //binding
    private lateinit var binding: ActivityMainBinding

    //others
    private lateinit var navHostFragment: NavHostFragment
    private val checkConnection: CheckConnection by lazy { CheckConnection(application) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        //check internet connection
        binding.apply {
            checkConnection.observe(this@MainActivity) {
                if (!it) {
                    fragmentContainerView.visibility = View.GONE
                    connectionLayout.visibility = View.VISIBLE
                } else {
                    fragmentContainerView.visibility = View.VISIBLE
                    connectionLayout.visibility = View.GONE
                }
            }
        }

    }
}