package com.pratwib.consumzy2.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pratwib.consumzy2.R
import com.pratwib.consumzy2.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        setSupportActionBar(binding.tbSearh)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }
}