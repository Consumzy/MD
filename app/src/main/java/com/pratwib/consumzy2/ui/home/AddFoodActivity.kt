package com.pratwib.consumzy2.ui.home

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.pratwib.consumzy2.MyApplication
import com.pratwib.consumzy2.R
import com.pratwib.consumzy2.database.Category
import com.pratwib.consumzy2.databinding.ActivityAddFoodBinding
import com.pratwib.consumzy2.ui.profile.CategoryViewModel
import com.pratwib.consumzy2.ui.profile.ViewModelFactory
import java.util.Calendar

@Suppress("NAME_SHADOWING")
class AddFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddFoodBinding

    private var list = mutableListOf<Category>()

    private val categoryViewModel: CategoryViewModel by viewModels {
        ViewModelFactory((application as MyApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etAddFoodExpired.setOnClickListener { datePicker() }
    }

    override fun onResume() {
        super.onResume()

        setupView()
    }

    private fun setupView() {
        setSupportActionBar(binding.tbAddFood)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        dropdownCategory()
    }

    private fun dropdownCategory() {
        categoryViewModel.getAllCategory().observe(this) { it ->
            list.clear()
            list.addAll(it)

            val items = list.map {
                it.category
            }

            val adapter = ArrayAdapter(this, R.layout.item_category_dropdown, items)
            binding.category.setAdapter(adapter)
            binding.category.onItemClickListener =
                AdapterView.OnItemClickListener { parent, _, position, _ ->
                    val itemSelected = parent.getItemAtPosition(position).toString()
                }
        }
    }

    private fun datePicker() {
        binding.etAddFoodExpired.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    val date = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    binding.etAddFoodExpired.setText(date)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }
}