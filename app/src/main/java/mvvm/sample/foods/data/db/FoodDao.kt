package mvvm.sample.foods.data.db

import android.arch.persistence.room.*
import mvvm.sample.foods.data.model.Food

@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFood(food: Food): Long

    @Delete
    fun deleteFood(food: Food): Int

    @Query("SELECT * from Food")
    fun selectAllFoods(): MutableList<Food>

}