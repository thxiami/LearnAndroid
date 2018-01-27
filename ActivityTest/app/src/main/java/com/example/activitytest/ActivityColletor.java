package com.example.activitytest;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by liyiwei on 2018/1/24.
 */

public class ActivityColletor {
    public static ArrayList<Activity> activities = new ArrayList<>();
    public static final String TAG = "ActivityColletor";

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }
    public static void showAll() {
        Log.d(TAG, "============Before showAll============");
        for (Activity activity:activities) {
            Log.d(TAG, "showAll: " + activity.toString());
        }
        Log.d(TAG, "============After showAll============");
    }
    public static void finishAll() {
        Log.d(TAG, "===========Before finishAll===========");
        for(Activity activity : activities) {
            Log.d(TAG, activity.toString() +" is finishing:" + activity.isFinishing());
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        Log.d(TAG, "===========After finishAll===========");
    }
}
