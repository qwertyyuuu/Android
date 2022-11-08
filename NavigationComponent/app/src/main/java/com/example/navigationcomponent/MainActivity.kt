package com.example.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.navigationcomponent.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private var viewBinding: ActivityMainBinding?= null
    private lateinit var controller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        controller = (supportFragmentManager.findFragmentById(R.id.containerView) as NavHostFragment).navController
        val bottomView = findViewById<BottomNavigationView>(R.id.bottom_nav_main)
        bottomView.setupWithNavController(controller)
    }

    fun changeBottomNavigationVisibility(isVisible: Boolean) {
        viewBinding?.bottomNavMain?.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

}