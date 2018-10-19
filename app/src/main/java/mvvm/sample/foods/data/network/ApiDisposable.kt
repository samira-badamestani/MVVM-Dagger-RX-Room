package mvvm.sample.foods.data.network

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

class ApiDisposable<T>(private val success: (body: T) -> Unit, private val failure: (error: ApiError) -> Unit = {}) : DisposableObserver<T>() {
    private val TAG = ApiDisposable::class.java.simpleName
    override fun onNext(t: T) {
        if (t == null || (t is List<*> && t.isEmpty()))
            failure(ApiError(ApiError.ApiStatus.EMPTY_RESPONSE))
        else
            success(t)
    }

    override fun onComplete() {
    }

    override fun onError(e: Throwable) {
        Log.d(TAG, "onError: $e")
        when (e) {
            is HttpException -> {
                val errorMessage = getErrorMessage(e.response().errorBody())
                failure(ApiError(ApiError.ApiStatus.BAD_RESPONSE, e.code(), errorMessage))
            }
            is SocketTimeoutException -> {
                failure(ApiError(ApiError.ApiStatus.TIMEOUT, message = e.localizedMessage))
            }
            is IOException -> {
                failure(ApiError(ApiError.ApiStatus.NO_CONNECTION, message = e.localizedMessage))
            }
            is NullPointerException -> {
                failure(ApiError(ApiError.ApiStatus.EMPTY_RESPONSE))
            }

            else -> failure(ApiError(ApiError.ApiStatus.NOT_DEFINED))
        }
    }

    private fun getErrorMessage(errorBody: ResponseBody?): String = try {
        val result = errorBody?.string()
        Log.d(TAG, "getErrorMessage() called with: errorBody = [$result]")
        val json = Gson().fromJson(result, JsonObject::class.java)
        json.toString()
    } catch (t: Throwable) {
        ""
    }


}