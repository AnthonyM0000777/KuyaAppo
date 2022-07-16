package com.cite.newscoopup.WeatherUtils


import com.cite.newscoopup.WeatherPojo.ModelClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getCurrentWeatherData(
            @Query("lat") latitude: String,
            @Query("lon") longitude: String,
            @Query("APPID") api_key: String
    ):Call<ModelClass>

    @GET("weather")
    fun getCityWeatherData(
            @Query("q") cityNames: String,
            @Query("APPID") api_key: String
    ):Call<ModelClass>
}