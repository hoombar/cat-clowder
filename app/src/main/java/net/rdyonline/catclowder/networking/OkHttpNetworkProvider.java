package net.rdyonline.catclowder.networking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpNetworkProvider implements NetworkProvider {

    private final Bitmap mFallbackImage;
    private OkHttpClient mClient;

    public OkHttpNetworkProvider(Bitmap fallbackImage) {
        this(fallbackImage, new OkHttpClient());
    }

    public OkHttpNetworkProvider(Bitmap fallbackImage, OkHttpClient client) {
        mFallbackImage = fallbackImage;
        mClient = client;
    }

    @Override
    public Bitmap newCatImage() {
        final String url = UrlFactory.get(CatApiPath.srcPng);

        Request request = new Request.Builder().url(url).build();

        try {
            Response response = mClient.newCall(request).execute();
            return BitmapFactory.decodeStream(response.body().byteStream());
        } catch (Exception e) {
            return mFallbackImage;
        }
    }

}
