package com.example.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var controller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = (supportFragmentManager.findFragmentById(R.id.containerView) as NavHostFragment).navController
        val bottomView = findViewById<BottomNavigationView>(R.id.bottom_nav_main)
        bottomView.setupWithNavController(controller)
    }
}