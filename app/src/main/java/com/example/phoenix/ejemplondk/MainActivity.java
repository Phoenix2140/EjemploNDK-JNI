package com.example.phoenix.ejemplondk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long tiempo_inicio, tiempo_final;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String texto = "Fibbonacci Recursivo de 33\n=====================\n\nMétodo Java:\nResultado= ";
        tiempo_inicio = System.currentTimeMillis();
        texto += fibonacci(33);
        tiempo_final = System.currentTimeMillis();
        texto += " Tiempo(ms): " + (tiempo_final - tiempo_inicio) + "\n\nMétodo C++:\nResultado= ";

        tiempo_inicio = System.currentTimeMillis();
        texto += fibboJni();
        tiempo_final = System.currentTimeMillis();
        texto += " Tiempo(ms): " + (tiempo_final - tiempo_inicio) + "\n";

        ((TextView) findViewById(R.id.jni_msg)).setText(texto);
    }

    public static int fibonacci(int n){
        if(n<2){
            return n;
        }else{
            return fibonacci(n-2)+fibonacci(n-1);
        }
    }

    public native String fibboJni();

    static{
        System.loadLibrary("fibonacci-jni");
    }
}
