package com.amk.fallhafez.model.net

import com.amk.fallhafez.model.data.FallResponse
import com.amk.fallhafez.util.BASE_URL
import com.amk.fallhafez.util.RandomNumber
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("ghazaliyathafez/")
    suspend fun takeFall(
        @Query("type") type: String = "ghazal",
        @Query("num") ghazalNum: Int = RandomNumber(1, 495).nextInt()
    ): FallResponse
}


fun createApiService(): ApiService {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}