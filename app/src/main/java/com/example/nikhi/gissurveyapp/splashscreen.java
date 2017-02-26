package com.example.nikhi.gissurveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by nikhi on 22-02-2017.
 */

public class splashscreen extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                       Intent intentLogin = new Intent(splashscreen.this,login.class);
                        startActivity(intentLogin);
               }
            }
        };
        timerThread.start();
    }
}
