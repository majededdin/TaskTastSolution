package majed.eddin.tasksolution.data.remote

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface ApiService {

    @GET("viewed/7.json?api-key=V74trQI0VCfuAq7x9oTp17dnxNSjGfBg")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun getArticles(): ResponseBody

}