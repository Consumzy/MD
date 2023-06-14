package com.pratwib.consumzy2.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.pratwib.consumzy2.R
import com.pratwib.consumzy2.databinding.ActivityProfileBinding
import com.pratwib.consumzy2.ui.home.HomeActivity
import com.pratwib.consumzy2.ui.scan.ScanActivity

@Suppress("UNUSED_EXPRESSION")
class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        bottomNavigation()
    }

    private fun setupView() {

        val cardMySummary = binding.cvProfileSummary
        cardMySummary.setOnClickListener {
            val mySummaryIntent = Intent(this, SummaryActivity::class.java)
            startActivity(mySummaryIntent)
        }

        val cardMyCategory = binding.cvProfileCategory
        cardMyCategory.setOnClickListener {
            val myCategoryIntent = Intent(this, CategoryActivity::class.java)
            startActivity(myCategoryIntent)
        }
    }

    private fun bottomNavigation() {
        val navView = binding.navView
        navView.selectedItemId = R.id.nav_profile
        navView.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this@ProfileActivity, HomeActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_scan -> {
                    startActivity(Intent(this@ProfileActivity, ScanActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }

                R.id.nav_profile -> true
            }
            false
        }
    }
}