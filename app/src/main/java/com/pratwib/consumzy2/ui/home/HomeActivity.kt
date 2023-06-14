package com.pratwib.consumzy2.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.pratwib.consumzy2.R
import com.pratwib.consumzy2.databinding.ActivityHomeBinding
import com.pratwib.consumzy2.ui.profile.ProfileActivity
import com.pratwib.consumzy2.ui.scan.ScanActivity


@Suppress("UNUSED_EXPRESSION")
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        bottomNavigation()
    }

    private fun setupView() {
        setSupportActionBar(binding.tbHome)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        val fabAddFood = binding.fabAddFood
        fabAddFood.setOnClickListener {
            val addFoodIntent = Intent(this, AddFoodActivity::class.java)
            startActivity(addFoodIntent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> {
                val searchIntent = Intent(this, SearchActivity::class.java)
                startActivity(searchIntent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun bottomNavigation() {
        val navView = binding.navView
        navView.selectedItemId = R.id.nav_home
        navView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> true

                R.id.nav_scan -> {
                    startActivity(Intent(this, ScanActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
            }
            false
        }
    }
}