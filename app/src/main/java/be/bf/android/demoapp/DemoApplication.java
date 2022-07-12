package be.bf.android.demoapp;

import android.app.Application;
import android.util.Log;

public class DemoApplication extends Application {

    private String hello = "Hello world";

    public String getHello() {
        return hello;
    }

//    @Override
//    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
//        super.registerActivityLifecycleCallbacks(callback);
//        Log.d("CALLBACK",callback.toString());
//    }
}
