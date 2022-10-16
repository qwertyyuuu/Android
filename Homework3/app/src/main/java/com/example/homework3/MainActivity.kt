package com.example.homework3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var firstFlag = false

    private val containerId: Int = R.id.fragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(containerId, Screen1.getInstance(), Screen1.FIRST_FRAGMENT_TAG)
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(containerId, Screen2.getInstance(), Screen2.SECOND_FRAGMENT_TAG)
            .addToBackStack(null)
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(containerId, Screen3.getInstance(), Screen3.THIRD_FRAGMENT_TAG)
            .addToBackStack(null)
            .commit()

    }

    fun replaceFragment() {}
}