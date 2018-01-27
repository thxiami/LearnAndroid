package com.example.activitytest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by liyiwei on 2018/1/24.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        Log.d("BaseActivity", "onCreate: " + this.getClass().getSimpleName());
        ActivityColletor.addActivity(this);
        ActivityColletor.showAll();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityColletor.removeActivity(this);

    }
}
