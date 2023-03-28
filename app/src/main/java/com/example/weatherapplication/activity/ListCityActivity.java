package com.example.weatherapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.weatherapplication.R;
import com.example.weatherapplication.adapter.WeatherListAdapter;
import com.example.weatherapplication.model.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

public class ListCityActivity extends AppCompatActivity {

    private RequestQueue requestQueue;
    ArrayList<Weather> weathers = new ArrayList();
    private ListView listCity;
    private TextView nameCityTextView;
    private String nameCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_city);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        nameCity = (String) b.getString("cityName");

        listCity = (ListView) findViewById(R.id.listCity);
        nameCityTextView = (TextView) findViewById(R.id.listTitle);

        getWeather();

    }


    private void getWeather() {
        this.requestQueue = Volley.newRequestQueue(getApplicationContext());

        String api_key = "d041897bb0e9ecf30de085339892ccc0";
        final String API_BASE_URL = "https://api.openweathermap.org/data/2.5/find?q="+ nameCity +"&units=metric&appid="+ api_key;


        @SuppressLint("SetTextI18n") StringRequest stringRequest = new StringRequest(Request.Method.POST, API_BASE_URL,
                response -> {
                    Toast.makeText(getApplicationContext(), "Received data", Toast.LENGTH_SHORT).show();

                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray weatherList = jsonObject.getJSONArray("list");

                        for (int i = 0; i < weatherList.length(); i++) {
                            JSONObject weatherData = weatherList.getJSONObject(i);
                            String id = weatherData.getString("id");
                            String name = weatherData.getString("name");
                            String country = weatherData.getJSONObject("sys").getString("country");
                            JSONObject main = weatherData.getJSONObject("main");
                            int pressure = main.getInt("pressure");
                            double temperature = main.getDouble("temp");
                            int humidity = main.getInt("humidity");
                            weathers.add(new Weather(id,name + " "+ country, temperature, humidity, pressure));

                        }

                        Toast.makeText(getApplicationContext(), "results : "+ weathers.size(), Toast.LENGTH_SHORT).show();

                        nameCityTextView.setText(nameCity.substring(0, 1).toUpperCase() + nameCity.substring(1));

                        ListAdapter weatherAdapter = new WeatherListAdapter(getApplicationContext(), weathers);
                        listCity.setAdapter(weatherAdapter);
                        listCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                Weather weather1 = weathers.get(position);
                                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                                intent.putExtra("weather1", weather1);
                                startActivity(intent);
                            }
                        });

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                },
                error -> Toast.makeText(getApplicationContext(), "Error no response", Toast.LENGTH_SHORT).show()
        );
        requestQueue.add(stringRequest);
    }
}