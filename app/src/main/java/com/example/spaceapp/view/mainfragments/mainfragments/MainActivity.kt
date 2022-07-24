package com.example.spaceapp.view.mainfragments.mainfragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.spaceapp.R
import com.example.spaceapp.databinding.ActivityMainBinding
import com.example.spaceapp.view.mainfragments.mainfragments.view.EntranceFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_SpaceApp)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, EntranceFragment.newInstance()).addToBackStack("").commit()
        }



    }//....








}