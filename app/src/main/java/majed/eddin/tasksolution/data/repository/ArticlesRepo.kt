package majed.eddin.tasksolution.data.repository

import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import majed.eddin.tasksolution.data.model.service.Result
import majed.eddin.tasksolution.data.remote.ApiClient
import majed.eddin.tasksolution.data.remote.ApiResponse
import majed.eddin.tasksolution.data.remote.ApiStatus
import majed.eddin.tasksolution.data.consts.Params

open class ArticlesRepo {

    private var apiService = ApiClient.getInstance()

    //---------------------------------------- ApiResponse Methods ---------------------------------

    private fun <M> getApiError(throwable: Throwable) = ApiResponse<M>().getErrorBody(throwable)

    //---------------------------------------- Global Methods ---------------------------------

    fun getArticles() = flow {
        emit(ApiResponse(ApiStatus.OnLoading))

        val restaurantsResponse =
            ApiResponse<Result>(
                apiService.getArticles().string(),
                Params.RESULTS, object : TypeToken<List<Result>>() {}.type
            )

        emit(restaurantsResponse.getApiResult())
    }.catch { emit(getApiError(it)) }

}