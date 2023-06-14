package com.pratwib.consumzy2.ui.home

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pratwib.consumzy2.R
import com.pratwib.consumzy2.databinding.ActivityAddFoodBinding
import com.pratwib.consumzy2.databinding.ActivityEditFoodBinding
import java.util.Calendar

class EditFoodActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    private fun setupView() {
        setSupportActionBar(binding.tbEditFood)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.etEditFoodExpired.setOnClickListener {
            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    val date = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                    binding.etEditFoodExpired.setText(date)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
    }

}