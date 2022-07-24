package com.example.spaceapp.repository

import com.example.spaceapp.utils.NASA_BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2Impl {
    private val nasaBaseUrl = NASA_BASE_URL
    fun mRetrofit(): DataAPI {
        val photoday = Retrofit.Builder()
            .baseUrl(nasaBaseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
        return photoday.create(DataAPI::class.java)


    }

    fun getPhotoD(apikey: String, date: String, pdCallback: Callback<DataPhotoDay>) {
        mRetrofit().getPhotoDay(apikey, date).enqueue(pdCallback)
    }

}





