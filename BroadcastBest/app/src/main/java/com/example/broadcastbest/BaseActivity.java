package com.example.broadcastbest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by liyiwei on 2018/1/26.
 */

public class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private ForceOfflineReceiver offlineReceiver;
    private String activityName = getClass().getSimpleName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        Log.d(TAG, "onCreate: " + activityName);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
        Log.d(TAG, "onDestroy: " + activityName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + activityName);

        offlineReceiver = new ForceOfflineReceiver();
        IntentFilter intentFilter = new IntentFilter("com.example.broadcastbest.FORCE_OFFLINE");
        registerReceiver(offlineReceiver, intentFilter);
        Log.d(TAG, "onResume: " + activityName + " registered FORCE_OFFLINE");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + activityName);

        if (offlineReceiver != null) {
            unregisterReceiver(offlineReceiver);
            offlineReceiver = null;
            Log.d(TAG, "onPause:" + activityName + " unregistered FORCE_OFFLINE");
        }
    }

    class ForceOfflineReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder= new AlertDialog.Builder(context);
            builder.setTitle("Waring");
            builder.setMessage("You are forced to offline.");
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCollector.finishAll();
                    Intent intentStart = new Intent(context, LoginActivity.class);
                    context.startActivity(intentStart);
                }
            });
            Log.d(TAG, "onReceive: before builder show");
            builder.show();
            Log.d(TAG, "onReceive: after builder show");
        }
    }
}
