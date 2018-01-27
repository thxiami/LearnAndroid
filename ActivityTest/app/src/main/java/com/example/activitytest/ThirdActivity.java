package com.example.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    public static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Log.d("ThirdActivity", "onCreate:" + this.toString());
        Log.d(TAG, "onCreate: TASK ID:" + getTaskId());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);

        Button button_3 = findViewById(R.id.button_3);
//        button_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ThirdActivity.this, ThirdActivity.class);
//                startActivity(intent);
//            }
//        });

        button_3.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
//               ActivityColletor.finishAll();
               FourthActivity.actionStart(ThirdActivity.this, "Xia", "Mi");
           }
        });

    }
}
