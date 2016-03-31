package net.rdyonline.catclowder;

import android.app.Application;

import net.rdyonline.catclowder.module.ContextModule;

public class CatClowderApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ContextModule.init(this);
    }

}
