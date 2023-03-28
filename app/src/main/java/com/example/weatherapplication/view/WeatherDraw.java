package com.example.weatherapplication.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.weatherapplication.model.Weather;

public class WeatherDraw extends View {
    private Paint rectStroke;
    private Paint rectFullRed;
    private Paint rectFullBlue;
    private Paint circleBlue;
    private Paint circleFullBlue;
    private Weather weather;

    private float minTemp = -20.0f;
    private float maxTemp = 40.0f;

    private int pressure = 0;
    private int minPressure = 800;
    private int maxPressure = 1200;
    private int stepPressure = 100;

    public WeatherDraw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public WeatherDraw(Context context) {
        super(context);
        init();
    }

    public WeatherDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
        invalidate(); //rappelle undraw
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        float width = getWidth();
        float height = getHeight();

        if(weather != null) {

            //A l'envers ...
            float fillRectWidth = (float) ((float) (weather.getTemp() - minTemp) / (maxTemp - minTemp) * width);
            canvas.translate(width / 2, 40);

            System.out.println(fillRectWidth);
            canvas.drawRect(0, fillRectWidth, 30, 150, rectFullRed);
            canvas.drawRect(0, 0, 30, 150, rectStroke);


            float humidity = weather.getHumidity();
            canvas.translate(0, height / 2 + 100);

            if (humidity >= 100.0f) {
                canvas.drawCircle(0, 0, 50, circleBlue);
            } else {
                RectF rectF = new RectF(0 - 50, 0 - 50, 50, 0 + 50);
                float angle = humidity / 100.0f * 360.0f;
                canvas.drawArc(rectF, -90, angle, true, circleFullBlue);
            }


        }


    }


    public void init(){
        Resources resources = getResources();
        this.rectStroke = new Paint();
        this.rectStroke.setStyle(Paint.Style.STROKE);
        this.rectStroke.setStrokeWidth(7f);
        this.rectStroke.setColor(Color.BLUE);

        this.rectFullRed= new Paint();
        this.rectFullRed.setStyle(Paint.Style.FILL);
        this.rectFullRed.setColor(Color.RED);

        this.rectFullBlue = new Paint();
        this.rectFullBlue.setStyle(Paint.Style.FILL);
        this.rectFullBlue.setColor(Color.BLUE);

        this.circleBlue = new Paint();
        this.circleBlue.setStyle(Paint.Style.STROKE);
        this.circleBlue.setColor(Color.BLUE);

        this.circleFullBlue = new Paint();
        this.circleFullBlue.setStyle(Paint.Style.FILL);
        this.circleFullBlue.setColor(Color.BLUE);


    }


















}
