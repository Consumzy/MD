package com.pratwib.consumzy2.ui.profile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.pratwib.consumzy2.MyApplication
import com.pratwib.consumzy2.adapter.CategoryAdapter
import com.pratwib.consumzy2.database.Category
import com.pratwib.consumzy2.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryBinding

    private var list = mutableListOf<Category>()

    private val categoryViewModel: CategoryViewModel by viewModels {
        ViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        setupView()
    }

    private fun setupView() {
        setSupportActionBar(binding.tbCategory)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        getCategory()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun getCategory() {
        val adapter = CategoryAdapter(list)
        binding.rvCategory.adapter = adapter
        binding.rvCategory.layoutManager = LinearLayoutManager(this)
        categoryViewModel.getAllCategory().observe(this) {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }


}