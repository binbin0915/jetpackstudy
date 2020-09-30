package cz.yb.jetpackdemo;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

public class App extends MultiDexApplication {
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance(){
        return instance;
    }
}
