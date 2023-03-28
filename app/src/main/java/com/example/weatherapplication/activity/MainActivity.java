package com.example.weatherapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weatherapplication.R;

public class MainActivity extends AppCompatActivity {

    EditText userText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = (EditText) findViewById(R.id.userText);
    }


    public void enter(View view) {

        String cityName = userText.getText().toString().trim();
        if (!cityName.isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), ListCityActivity.class);
            intent.putExtra("cityName", cityName);
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Please enter a city name.", Toast.LENGTH_SHORT).show();
        }
    }


}