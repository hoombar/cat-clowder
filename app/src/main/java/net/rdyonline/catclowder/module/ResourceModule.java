package net.rdyonline.catclowder.module;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;

import static net.rdyonline.catclowder.module.ContextModule.applicationContext;

public class ResourceModule {

    public static String stringRes(@StringRes int resourceId) {
        return applicationContext().getString(resourceId);
    }

    public static Drawable drawableRes(@DrawableRes int resourceId) {
        return ContextCompat.getDrawable(applicationContext(), resourceId);
    }


}
