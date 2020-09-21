package com.cagudeloa.harrypotter.vo

import com.cagudeloa.harrypotter.domain.WebService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val webService: WebService by lazy {
        Retrofit.Builder()
            .baseUrl("https://hp-api.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }

}