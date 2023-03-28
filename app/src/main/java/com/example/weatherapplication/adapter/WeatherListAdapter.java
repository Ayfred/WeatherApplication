package com.example.weatherapplication.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.weatherapplication.model.Weather;

import java.util.List;

import com.example.weatherapplication.R;


public class WeatherListAdapter extends ArrayAdapter<Weather> {

    private Context context;
    private List<Weather> weather;
    private LayoutInflater inflater;

    public WeatherListAdapter(Context context, List<Weather> weather) {
        super(context, -1, weather);
        this.context = context;
        this.weather = weather;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.weather_line, parent, false);

        TextView cityName = rowView.findViewById(R.id.selectCityWeather);

        Weather weather = this.weather.get(position);

        cityName.setText(weather.getName());

        return rowView;
    }
}
