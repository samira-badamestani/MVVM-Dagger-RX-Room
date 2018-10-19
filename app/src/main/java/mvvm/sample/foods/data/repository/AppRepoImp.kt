package mvvm.sample.foods.data.repository

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import mvvm.sample.foods.data.db.AppDatabase
import mvvm.sample.foods.data.model.Food
import mvvm.sample.foods.data.model.FoodDto
import mvvm.sample.foods.data.network.ApiDisposable
import mvvm.sample.foods.data.network.ApiError
import mvvm.sample.foods.data.network.ApiService

class AppRepoImp(
    val apiService: ApiService,
    val database: AppDatabase
) : AppRepository {
    private val TAG = AppRepoImp::class.java.simpleName
    override fun getFoods(success: (FoodDto) -> Unit, failure: (ApiError) -> Unit, terminate: () -> Unit): Disposable {
        return apiService
            .getHome()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnTerminate(terminate)
            .subscribeWith(
                ApiDisposable<FoodDto>(
                    {

                        success(it)
                    },
                    failure
                )
            )
    }

    override fun insertFood(food: Food) : Disposable =
        Observable
            .fromCallable { database.foodDao().insertFood(food) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d(TAG, "food added: subscribe: $it")
            }


}