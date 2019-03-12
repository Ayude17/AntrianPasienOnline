package com.simpus.antrianpasienonline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread timerThread = new Thread() {
            public void run() {
                try {

//                    startService(new Intent(getApplicationContext(), EventPusherService.class));

                    sleep(2000);
                    SharedPreferences sharedPreferences = getSharedPreferences("DATA", Context.MODE_PRIVATE);
                    //SharedPreferences dapat digunakan untuk mencegah aplikasi agar tidak logout walaupun aplikasi ditutup

//                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                    finish();

                    if(sharedPreferences.getBoolean("login", false)){
                        Intent intent = new Intent(SplashScreenActivity.this, MenuActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{

                }
            }
        };
        timerThread.start();
    }
}
