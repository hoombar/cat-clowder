package net.rdyonline.catclowder.networking;

import android.graphics.Bitmap;

public class RetrofitNetworkProvider implements NetworkProvider {

    private final Bitmap mFallbackImage;

    public RetrofitNetworkProvider(Bitmap fallbackImage) {
        mFallbackImage = fallbackImage;
    }

    @Override
    public Bitmap newCatImage() {
        return mFallbackImage;
    }
}
