package com.helicopter.data.network.retrofit

import com.helicopter.data.network.api.ListApi
import com.helicopter.data.network.api.ScheduleAPI
import com.helicopter.data.network.api.UtilsApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://journal.bsuir.by/api/v1/"

    private fun getClient() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getScheduleApi(): ScheduleAPI = getClient().create(
        ScheduleAPI::class.java
    )

    fun getListApi(): ListApi = getClient().create(
        ListApi::class.java
    )

    fun getUtilsApi(): UtilsApi = getClient().create(
        UtilsApi::class.java
    )
}