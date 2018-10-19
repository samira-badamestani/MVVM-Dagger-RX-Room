package mvvm.sample.foods.data.network

import io.reactivex.Observable
import mvvm.sample.foods.data.model.FoodDto
import retrofit2.http.GET

interface ApiService {

    @GET("api/")
    fun getHome(
    ): Observable<FoodDto>


}