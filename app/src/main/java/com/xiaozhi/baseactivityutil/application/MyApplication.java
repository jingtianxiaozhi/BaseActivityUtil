package com.xiaozhi.baseactivityutil.application;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liudezhi on 16/9/19.
 */
public class MyApplication extends Application {

    private Handler mHandler = new Handler();
    private static List<Activity> activityList = new LinkedList<>();

    public void showMainToast(final String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MyApplication.this, str, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(MyApplication.this, str, Toast.LENGTH_SHORT).show();
        }
    }

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

}
