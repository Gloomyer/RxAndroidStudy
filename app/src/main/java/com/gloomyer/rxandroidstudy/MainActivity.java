package com.gloomyer.rxandroidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gloomyer.rx_asynctask.RxAsyncTaskAct;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void next(View v) {
        startActivity(new Intent(this, RxAsyncTaskAct.class));
    }
}
