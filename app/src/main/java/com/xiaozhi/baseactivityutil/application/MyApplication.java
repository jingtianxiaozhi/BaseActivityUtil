package com.xiaozhi.baseactivityutil.application;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liudezhi on 16/9/19.
 */
public class MyApplication extends Application {

    private static List<Activity> activityList = new LinkedList<>();


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
