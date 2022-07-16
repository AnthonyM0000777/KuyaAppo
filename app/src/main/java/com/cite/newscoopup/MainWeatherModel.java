package com.cite.newscoopup;

import org.json.JSONObject;

public class MainWeatherModel {

    private String temperature;
    private String city;
    private String iconName;
    private int condition;

    public String getTemperature() {
        return temperature;
    }

    public String getCity() {
        return city;
    }

    public String getIconName() {
        return iconName;
    }

    public static MainWeatherModel fromJson(JSONObject jsonObject){
        try {
            MainWeatherModel weatherData = new MainWeatherModel ();
            weatherData.city = jsonObject.getString ("name");
            weatherData.condition = jsonObject.getJSONArray ("weather").getJSONObject (0).getInt ("id");
            weatherData.iconName = updateWeatherIcon(weatherData.condition);
            double tempResult = (jsonObject.getJSONObject ("main").getDouble ("temp")- 273.15);
            int roundedValue = (int) Math.rint (tempResult);
            weatherData.temperature = Integer.toString (roundedValue);
            return weatherData;
        }catch (Exception e){
            e.printStackTrace ();
            return null;
        }
    }

    private static String updateWeatherIcon(int condition) {
        if(condition >= 0 && condition < 300){
            return "sunny";
        }else if(condition >= 300 && condition < 500){
            return "rainy";
        }else if(condition >= 500 && condition <= 600){
            return "rainy";
        }else if(condition >=600 && condition <=700){
            return "sunny";
        }else if(condition >= 701 && condition < 771){
            return "sunny";
        }else if(condition >=  772 && condition <800){
            return "sunny";
        }else if(condition == 800){
            return "sunny";
        }else if(condition >= 800 && condition<=804){
            return "sunny";
        }else if(condition >= 900 && condition <=902){
            return "sunny";
        }else if(condition == 903){
            return "sunny";
        }else if(condition == 904){
            return "sunny";
        }else if(condition == 905 && condition<=1000){
            return "sunny";
        }
        return "nothing";
    }

}
