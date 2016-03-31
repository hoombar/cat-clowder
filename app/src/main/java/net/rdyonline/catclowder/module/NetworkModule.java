package net.rdyonline.catclowder.module;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import net.rdyonline.catclowder.R;
import net.rdyonline.catclowder.helper.BitmapHelper;
import net.rdyonline.catclowder.networking.NetworkProvider;
import net.rdyonline.catclowder.networking.RetrofitNetworkProvider;

import static net.rdyonline.catclowder.module.ResourceModule.drawableRes;

public class NetworkModule {

    public static NetworkProvider networkProvider() {
        Drawable drawable = drawableRes(R.drawable.cat);
        Bitmap bitmap = BitmapHelper.getBitmap(drawable);

        return new RetrofitNetworkProvider(bitmap);
    }

}
