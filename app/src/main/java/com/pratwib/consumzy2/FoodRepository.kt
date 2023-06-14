package com.pratwib.consumzy2

import androidx.lifecycle.LiveData
import com.pratwib.consumzy2.database.Category
import com.pratwib.consumzy2.database.Food
import com.pratwib.consumzy2.database.FoodDao
import com.pratwib.consumzy2.database.FoodProfile
import com.pratwib.consumzy2.database.Unit

class FoodRepository(private val studentDao: FoodDao) {
    fun getAllFood(): LiveData<List<Food>> = studentDao.getAllFood()
    fun getAllUnit(): LiveData<List<Unit>> = studentDao.getAllUnit()
    fun getAllCategory(): LiveData<List<Category>> = studentDao.getAllCategory()
    fun getAllFoodProfile(): LiveData<List<FoodProfile>> = studentDao.getAllFoodProfile()
}