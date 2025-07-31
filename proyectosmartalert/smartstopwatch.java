package com.example.proyectosmartalert;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;
import java.util.Locale;

public class smartstopwatch extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor mySensor;

    private Button Rbutton;

    private TextView textView, textView2;
    boolean fin, pres = false, star;
    int seconds, minutes, milliSeconds;
    long millisecondTime, startTime, timeBuff, updateTime = 0L ;
    Handler handler;
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            millisecondTime = SystemClock.uptimeMillis() - startTime;
            updateTime = timeBuff + millisecondTime;
            seconds = (int) (updateTime / 1000);
            minutes = seconds / 60;
            seconds = seconds % 60;
            milliSeconds = (int) (updateTime % 1000);

            textView.setText(MessageFormat.format("{0}:{1}:{2}", minutes, String.format(Locale.getDefault(), "%02d", seconds), String.format(Locale.getDefault(),"%01d", milliSeconds)));
            handler.postDelayed(this, 0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.smart_stopwatch);

        Rbutton = findViewById(R.id.Rbutton);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mySensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);

        handler = new Handler(Looper.getMainLooper());
        textView.setText("00:00:00");
        Rbutton.setText("Iniciar");

        Rbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pres){
                    pres=false;
                    fin=false;
                    star=false;
                    millisecondTime = 0L ;
                    startTime = 0L ;
                    timeBuff = 0L ;
                    updateTime = 0L ;
                    seconds = 0 ;
                    minutes = 0 ;
                    milliSeconds = 0 ;
                    textView.setText("00:00:00");
                    Rbutton.setText("Iniciar");
                }
                else{
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                star=true;}

            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType()== Sensor.TYPE_ACCELEROMETER){
            float[] values=event.values;
            float z = values[2];


            if(z < -9){
                textView2.setText("down");
                if (star){
                    fin=true;
                }



            }else{
                textView2.setText("up");
                if(fin) {
                    timeBuff += millisecondTime;//parte del codigo que me interesa
                    handler.removeCallbacks(runnable);
                    Rbutton.setEnabled(true);
                    pres=true;
                    Rbutton.setText("Reiniciar");

                }

            }

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onStop(){
        super.onStop();
        sensorManager.unregisterListener(this);
    }

}

