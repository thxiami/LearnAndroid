package com.example.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
    public static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        Log.d(TAG, "onCreate: TASK ID:" + getTaskId());

//        Intent intent = getIntent();
//        String data = intent.getStringExtra("Extra_data");
//        Log.d(TAG, "onCreate: getdata from FirstActivity " + data );


        Button button_2 = findViewById(R.id.button_2);
//        button_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intentToFirstActivity = new Intent();
//                intentToFirstActivity.putExtra("data_return", "Hello 1");
//                setResult(RESULT_OK, intentToFirstActivity);
//                finish();
//            }
//        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "Hello from backpressed.");
        setResult(RESULT_OK, intent);
        finish();
    }
}
