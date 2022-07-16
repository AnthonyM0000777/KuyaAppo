package com.cite.newscoopup.WeatherUtils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiWeatherUtil {

    private var retrofit:Retrofit?=null
    const val API_KEY = "9a268d5e948445eed5557c1e922cc1d2"
    var BASE_URL = "https://api.openweathermap.org/data/2.5/weather/";
    fun getApiInterface():WeatherApi?{
        if (retrofit==null){
            retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit!!.create(WeatherApi::class.java)
    }
}