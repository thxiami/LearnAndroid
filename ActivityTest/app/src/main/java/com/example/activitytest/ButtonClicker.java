package com.example.activitytest;

import android.view.View;
import android.widget.Toast;

/**
 * Created by liyiwei on 2018/1/23.
 */

public class ButtonClicker implements View.OnClickListener {
    @Override
    public void onClick(View v){
        Toast.makeText(new FirstActivity(), "Test interface",
                Toast.LENGTH_SHORT).show();
    }
}
