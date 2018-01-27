package com.example.activitylifecycletest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainLayoutActivity extends AppCompatActivity {
    public static final String TAG = "MainLayoutActivity ";

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: " + this.getLocalClassName());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate:start ");

        if (savedInstanceState != null) {
            String data = savedInstanceState.getString("data_key");
            Log.d(TAG, "onCreate: get data from saved" + data);
        }
        setContentView(R.layout.main_layout);

        Button button_normal = (Button) findViewById(R.id.start_normal_activity);
        Button button_dialog = (Button) findViewById(R.id.start_dialog_activity);

        button_normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked button_normal");
                Intent intent = new Intent(MainLayoutActivity.this, NormalActivity.class);
                startActivity(intent);
            }
        });

        button_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Clicked button_dialog");
                Intent intent = new Intent(MainLayoutActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String data = "Somethind u just typed.";
        outState.putString("data_key", data);
    }
}

