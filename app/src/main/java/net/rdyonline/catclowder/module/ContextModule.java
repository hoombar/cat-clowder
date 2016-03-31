package net.rdyonline.catclowder.module;

import android.app.Application;
import android.content.Context;

public class ContextModule {

    private static Context context;

    public static void init(Context context) {
        if (context instanceof Application) {
            ContextModule.context = context.getApplicationContext();
        }

        ContextModule.context = context;
    }

    public static Context applicationContext() {
        return context;
    }

}
