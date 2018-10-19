package mvvm.sample.foods.ui

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import mvvm.sample.foods.data.model.Food
import mvvm.sample.foods.data.model.FoodDto
import mvvm.sample.foods.data.network.ApiError
import mvvm.sample.foods.data.repository.AppRepository
import mvvm.sample.foods.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(appRepository: AppRepository) : BaseViewModel() {
    private val TAG = HomeViewModel::class.java.simpleName
    val homeData: MutableLiveData<FoodDto> by lazy { MutableLiveData<FoodDto>() }
    val error : MutableLiveData<ApiError> by lazy { MutableLiveData<ApiError>() }

    init {
        appRepository.getFoods(

            { foodDto ->
                Log.d(TAG, "getHomeData.success() called with: $foodDto")
                homeData.postValue(foodDto)
                if(foodDto.results.size>0){
                    for (food in foodDto.results){
                        appRepository.insertFood(food).also { compositeDisposable.add(it) }
                    }
                }
            },
            {
                Log.d(TAG, "getHomeData.error() called with: $it")
                error.value = it
            },
            {

            }
        ).also { compositeDisposable.add(it) }
    }



}