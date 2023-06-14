package com.pratwib.consumzy2.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.Date

@Entity
data class Food(
    @PrimaryKey(autoGenerate = true)
    val foodId: Int,
    val name: String,
    val quantity: Float,
    val cId: Int,
    val expiredDate: Date,
    val place: String,
    val timestamp: Long,
)

@Entity
data class Category(
    @PrimaryKey(autoGenerate = true)
    val catId: Int = 0,
    val category: String,
    val color: Int,
)

data class FoodProfile(
    @Embedded val food: Food,
    @Relation(parentColumn = "cId", entityColumn = "catId")
    val categories: List<Category>
)