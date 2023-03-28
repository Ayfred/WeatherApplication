package com.example.weatherapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.weatherapplication.R;
import com.example.weatherapplication.model.Weather;
import com.example.weatherapplication.view.WeatherDraw;

public class DetailActivity extends AppCompatActivity {

    private Weather weather;
    private WeatherDraw weatherDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        weather = (Weather) b.getSerializable("weather1");
        this.weatherDraw = findViewById(R.id.weatherDraw);

        getInfo(weather);
        createDraw();
    }


    private void getInfo(Weather weather) {

        TextView nameTextView = (TextView) findViewById(R.id.DetailCityName);
        TextView TemperatureTextView = (TextView) findViewById(R.id.DetailTemperature);
        TextView pressionTextView = (TextView) findViewById(R.id.DetailPression);
        TextView humidityTextView = (TextView) findViewById(R.id.DetailHumidity);

        weatherDraw.setWeather(weather);

        nameTextView.setText(weather.getName());
        TemperatureTextView.setText(String.format(getString(R.string.temp_rature), String.valueOf(weather.getTemp())));
        pressionTextView.setText(String.format(getString(R.string.pression), String.valueOf(weather.getPressure())));
        humidityTextView.setText(String.format(getString(R.string.humidit),  String.valueOf(weather.getHumidity())));
    }

    public void createDraw(){
        WeatherDraw weatherDraw = findViewById(R.id.weatherDraw);
    }
}