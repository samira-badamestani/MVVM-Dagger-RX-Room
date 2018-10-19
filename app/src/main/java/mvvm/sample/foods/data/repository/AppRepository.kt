package mvvm.sample.foods.data.repository

import io.reactivex.disposables.Disposable
import mvvm.sample.foods.data.model.Food
import mvvm.sample.foods.data.model.FoodDto
import mvvm.sample.foods.data.network.ApiError

interface AppRepository {

    fun getFoods(
        success: (FoodDto) -> Unit,
        failure: (ApiError) -> Unit = {},
        terminate: () -> Unit = {}
    ): Disposable

    fun insertFood(food: Food): Disposable
}