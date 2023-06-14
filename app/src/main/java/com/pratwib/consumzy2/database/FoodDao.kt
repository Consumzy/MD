package com.pratwib.consumzy2.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFood(food: List<Food>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUnit(unit: List<Unit>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCategory(category: List<Category>)

    @Query("SELECT * from food")
    fun getAllFood(): LiveData<List<Food>>

    @Transaction
    @Query("SELECT * from unit")
    fun getAllUnit(): LiveData<List<Unit>>

    @Transaction
    @Query("SELECT * from category")
    fun getAllCategory(): LiveData<List<Category>>

    @Transaction
    @Query("SELECT * from food")
    fun getAllFoodProfile(): LiveData<List<FoodProfile>>
}