package net.rdyonline.catclowder.randomcat;

import android.graphics.Bitmap;

import static net.rdyonline.catclowder.module.NetworkModule.networkProvider;

public class RandomCatPresenterImpl implements RandomCatPresenter {

    private final RandomCatView mView;
    private final RandomCatInteractor mRandomCatInteractor;

    public RandomCatPresenterImpl(RandomCatView view) {
        this(view, new RandomCatNetworkInteractor(networkProvider()));
    }

    public RandomCatPresenterImpl(RandomCatView view, RandomCatInteractor interactor) {
        mView = view;
        mRandomCatInteractor = interactor;
    }

    @Override
    public void requestNewImage() {
        mView.imageLoading();

        mRandomCatInteractor.loadImageAsync(this);
    }

    @Override
    public void newImageAvailable(Bitmap image) {
        mView.changeImage(image);
    }

}
