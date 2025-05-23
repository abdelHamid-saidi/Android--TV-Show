package data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import utils.Constants

object RetrofitClient {
    val api: data.service.TvShowApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(data.service.TvShowApiService::class.java)
    }
}