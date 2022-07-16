package com.cite.newscoopup.WeatherPojo

import com.google.gson.annotations.SerializedName

data class Weather(

        @SerializedName("id") val id:Int,
        @SerializedName("main") val main:String,
        @SerializedName("description") val description:String,
        @SerializedName("icon") val icon:String

)
/*
val  sdf = SimpleDateFormat("dd/MM/yyyy hh:mm")
val currentDate = sdf.format(Date())
dateAndTime.text  = currentDate
maxTemp.text = "Day" +  kelvinToCelcius(body!!.main.temp_max) + "°"
minTemp.text = "Night" +  kelvinToCelcius(body!!.main.temp_min) + "°"
temp.text = "" +  kelvinToCelcius(body!!.main.temp) + "°"
feelsLike.text = "Feels Like" +  kelvinToCelcius(body!!.main.feels_like) + "°"
weather.text = body.weather[0].main
sunrise.text = timeStampToLocalDate(body.sys.sunrise.toLong())
sunset.text = timeStampToLocalDate(body.sys.sunset.toLong())
pressure.text = body.main.pressure.toString()
humidity.text = body.main.humidity.toString() + "%"
wind.text = body.wind.speed.toString() + "m/s"

tempFare.text = "" + ((kelvinToCelcius(body.main.temp)).times(1.8).plus(32).roundToInt())
cityName.setText(body.name)
*/