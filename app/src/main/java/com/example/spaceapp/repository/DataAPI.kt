package com.example.spaceapp.repository

import com.example.spaceapp.utils.API_DATE
import com.example.spaceapp.utils.API_KEY
import com.example.spaceapp.utils.PLANETARY_APOD
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DataAPI {
    @GET(PLANETARY_APOD)
    fun getPhotoDay(
        @Query(API_KEY) apikey: String,
        @Query(API_DATE) date: String,

        ): Call<DataPhotoDay>




}