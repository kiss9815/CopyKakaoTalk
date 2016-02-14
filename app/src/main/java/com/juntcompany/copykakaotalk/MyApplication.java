package com.juntcompany.copykakaotalk;

import android.app.Application;
import android.content.Context;

/**
 * Created by EOM on 2016-02-14.
 */
public class MyApplication extends Application {
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
    public static Context getContext(){
        return context;
    }

}
