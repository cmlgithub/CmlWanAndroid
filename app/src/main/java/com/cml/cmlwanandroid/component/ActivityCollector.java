package com.cml.cmlwanandroid.component;

import android.app.Activity;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chenmingliang on 2018/4/18.
 */

public class ActivityCollector {

    private static ActivityCollector activityCollector = null;

    private Set<Activity> activitySet = null;

    private ActivityCollector(){}

    public synchronized static ActivityCollector getInstance(){
        if(activityCollector == null){
            activityCollector = new ActivityCollector();
        }
        return activityCollector;
    }

    public void addActivity(Activity activity){
        if(activitySet == null){
            activitySet = new HashSet<>();
        }
        activitySet.add(activity);
    }

    public void removeActivity(Activity activity){
        if(activitySet != null){
            activitySet.remove(activity);
        }
    }

    public void exitApp(){
        if(activitySet != null){
            synchronized (activitySet){
                for(Activity activity : activitySet){
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

}
