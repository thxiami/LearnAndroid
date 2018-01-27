package com.example.activitytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FourthActivity extends BaseActivity {

    public static final String TAG = "FourthActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Intent intent = getIntent();
        String data1 = intent.getStringExtra("dataKey1");
        String data2 = intent.getStringExtra("dataKey2");
        Log.d("FourthActivity", "get from 3rd activity, data1" + data1 + "data2:" + data2);
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, FourthActivity.class);
        intent.putExtra("dataKey1", data1);
        intent.putExtra("dataKey2", data2);
        context.startActivity(intent);
    }
}
