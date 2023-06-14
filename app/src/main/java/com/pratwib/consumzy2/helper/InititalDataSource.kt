package com.pratwib.consumzy2.helper

import android.graphics.Color
import com.pratwib.consumzy2.database.Category
import com.pratwib.consumzy2.database.Unit

object InitialDataSource {
    fun getUnits(): List<Unit> {
        return listOf(
            Unit(unit = "kg"),
            Unit(unit = "gram"),
            Unit(unit = "pcs"),
            Unit(unit = "ons"),
            Unit(unit = "packs"),
            Unit(unit = "liter"),
            Unit(unit = "liter"),
        )
    }

    fun getCategories(): List<Category> {
        return listOf(
            Category(category = "Meats", color = Color.parseColor("#000000")),
            Category(category = "Fruits", color = Color.parseColor("#000000")),
            Category(category = "Vegetables", color = Color.parseColor("#000000")),
            Category(category = "Herbs and Spices", color = Color.parseColor("#000000")),
            Category(category = "Oils", color = Color.parseColor("#000000")),
            Category(category = "Frozen Food", color = Color.parseColor("#000000")),
            Category(category = "Flours", color = Color.parseColor("#000000")),
            Category(category = "Sauces", color = Color.parseColor("#000000")),
        )
    }
}