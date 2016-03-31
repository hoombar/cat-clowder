package net.rdyonline.catclowder.reals;

import android.graphics.Bitmap;

import net.rdyonline.catclowder.randomcat.RandomCatPresenter;

public class RealRandomCatPresenter implements RandomCatPresenter {

    Bitmap bitmap;

    @Override
    public void requestNewImage() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void newImageAvailable(Bitmap image) {
        bitmap = image;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

}
