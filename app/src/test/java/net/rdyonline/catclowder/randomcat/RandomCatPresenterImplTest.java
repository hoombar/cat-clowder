package net.rdyonline.catclowder.randomcat;

import android.graphics.Bitmap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class RandomCatPresenterImplTest {

    private RandomCatPresenterImpl mRandomCatPresenter;

    @Mock
    RandomCatInteractor mMockInteractor;
    @Mock
    RandomCatView mMockView;
    @Mock
    Bitmap mMockBitmap;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mRandomCatPresenter = new RandomCatPresenterImpl(mMockView, mMockInteractor);
    }

    @Test
    public void requestImageShouldDelegateToInteractor() {
        mRandomCatPresenter.requestNewImage();

        verify(mMockInteractor).loadImageAsync(any(RandomCatPresenter.class));
    }

    @Test
    public void newImageAvailableShouldUpdateView() {
        mRandomCatPresenter.newImageAvailable(mMockBitmap);

        verify(mMockView).changeImage(mMockBitmap);
    }

}