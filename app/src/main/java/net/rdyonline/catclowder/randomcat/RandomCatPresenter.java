package net.rdyonline.catclowder.randomcat;

import android.graphics.Bitmap;

public interface RandomCatPresenter {

    void requestNewImage();

    void newImageAvailable(Bitmap image);
}
