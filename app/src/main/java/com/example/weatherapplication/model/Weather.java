package com.example.weatherapplication.model;

import java.io.Serializable;

public class Weather implements Serializable {

    private Double temp;
    private int humidity;
    private int pressure;
    private String name;
    private int id;


    public Weather(String id, String name, Double temp, int humidity, int pressure) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
}
