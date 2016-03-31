package net.rdyonline.catclowder.module;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import static net.rdyonline.catclowder.module.ContextModule.applicationContext;

public class ResourceModule {

    public static String stringRes(@StringRes int resourceId) {
        return applicationContext().getString(resourceId);
    }

    public static Drawable drawableRes(@DrawableRes int resourceId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return applicationContext().getDrawable(resourceId);
        } else {
            //noinspection deprecation
            return applicationContext().getResources().getDrawable(resourceId);
        }
    }


}
