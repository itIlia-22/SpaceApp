package com.example.spaceapp.viewmodel

import android.icu.util.Calendar
import android.os.Build
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spaceapp.BuildConfig
import com.example.spaceapp.repository.DataPhotoDay
import com.example.spaceapp.repository.Retrofit2Impl
import com.example.spaceapp.utils.API_ERROR
import com.example.spaceapp.utils.UNKNOWN_ERROR
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.SocketTimeoutException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MyViewModel(
    private val LiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val retrofit2Impl: Retrofit2Impl = Retrofit2Impl(),
) : ViewModel() {
    fun getLiveData() = LiveData


    fun dayRequest(day: Int) {
        val date = pdate(day)
        LiveData.postValue(AppState.Loading)
        val apikey = BuildConfig.NASA_API_KEY
        if (apikey.isBlank()) {
            LiveData.postValue(AppState.Error(SocketTimeoutException(API_ERROR)))
        } else {
            retrofit2Impl.getPhotoD(apikey, date, callback)
        }

    }


    val callback = object : Callback<DataPhotoDay> {
        override fun onResponse(call: Call<DataPhotoDay>, response: Response<DataPhotoDay>) {
            if (response.isSuccessful && response.body() != null) {
                LiveData.postValue(AppState.Success(response.body()!!))
            } else {
                LiveData.postValue(AppState.Error(SocketTimeoutException(UNKNOWN_ERROR)))
            }
        }

        override fun onFailure(call: Call<DataPhotoDay>, t: Throwable) {
            LiveData.postValue(AppState.Error(SocketTimeoutException(UNKNOWN_ERROR)))
        }

    }

    fun pdate(day: Int): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val yesterday = LocalDateTime.now().minusDays(day.toLong())
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            yesterday.format(formatter)

        } else {
            val calendar: Calendar = Calendar.getInstance()
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
            calendar.add(Calendar.DAY_OF_MONTH, (-day))
            simpleDateFormat.format(calendar.time)

        }

    }

}