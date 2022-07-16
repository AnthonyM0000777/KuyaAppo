package com.cite.newscoopup;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainWeather extends AppCompatActivity {

    //final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";
    final String APP_ID = "9a268d5e948445eed5557c1e922cc1d2"; //api key
    final long MIN_TIME = 5000; //equals to 5 seconds
    final long MIN_DISTANCE = 1000;  //equals to 1 km
    final int REQUEST_CODE = 102;

    String LOCATION_PROVIDER = LocationManager.GPS_PROVIDER;
    LocationManager mLocationManager;
    android.location.LocationListener mLocationListener;


    Button cityBtn;
    ImageView imgWeatherIcon;
    TextView txtWeatherTemp, txtCityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main_weather);

        cityBtn = findViewById (R.id.idBTN);
        imgWeatherIcon = findViewById (R.id.idSignWeather);
        txtWeatherTemp = findViewById (R.id.idTemp);
        txtCityName = findViewById (R.id.idLoc);

        cityBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainWeather.this, MainCity.class);
                startActivity (i);
            }
        });

    }

    private void getWeatherForCurrentLocation() {
        mLocationManager = (LocationManager) getSystemService (Context.LOCATION_SERVICE);

        mLocationListener = new android.location.LocationListener () {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                String longitude = String.valueOf (location.getLongitude ());
                String latitude = String.valueOf (location.getLatitude ());




                Log.d ("MainWeather", "Longitude is = " + longitude);
                Log.d ("MainWeather", "Latitude is =" + latitude);

                RequestParams params = new RequestParams ();
                params.put ("lat", latitude);
                params.put ("lon", longitude);
                params.put ("appid", APP_ID);

                doneNetworking (params);
            }
        };



        if(ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.requestLocationUpdates (LOCATION_PROVIDER, MIN_TIME, MIN_DISTANCE, mLocationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult (requestCode, permissions, grantResults);

        if(requestCode==REQUEST_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                getWeatherForCurrentLocation ();
            }else {
                Toast.makeText (this, "App will not work", Toast.LENGTH_SHORT).show ();
            }
        }

    }

    private void doneNetworking(RequestParams params) {
        AsyncHttpClient client = new AsyncHttpClient ();
        client.get (WEATHER_URL, params, new JsonHttpResponseHandler () {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess (statusCode, headers, response);
                Log.d ("MainWeather", "Success JSON Data" + response.toString ());

                MainWeatherModel weatherData = MainWeatherModel.fromJson(response);
                updateUI(weatherData);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Toast.makeText (MainWeather.this, "Failed to get", Toast.LENGTH_SHORT).show ();
            }
        });
    }

    private void updateUI(MainWeatherModel weather) {
        txtWeatherTemp.setText (weather.getTemperature ());
        txtCityName.setText (weather.getCity ());
        int resourceID = getResources ().getIdentifier (weather.getIconName (), "drawable", getPackageName ());
        imgWeatherIcon.setImageResource (resourceID);
    }

    @Override
    protected void onResume() {
        super.onResume ();
        Log.d ("MainWeather", "onResume() Called");
        Intent i = getIntent ();
        String cityName = i.getStringExtra ("CityName");

        if(cityName != null){
            getWeatherForNewCity (cityName);
        }else {
            getWeatherForCurrentLocation ();
        }
    }

    private void getWeatherForNewCity(String city){
        RequestParams params = new RequestParams ();
        params.put ("q", city);
        params.put ("appid", APP_ID);
        doneNetworking (params);
    }

    @Override
    protected void onPause() {
        super.onPause ();
        Log.d ("MainWeather", "onPause() Called");
    }
}