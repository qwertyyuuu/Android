package com.example.homework4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val containerId: Int = R.id.fragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(containerId, Fragment1.getInstance(), Fragment1.FIRST_FRAGMENT_TAG)
            .commit()
    }
}
