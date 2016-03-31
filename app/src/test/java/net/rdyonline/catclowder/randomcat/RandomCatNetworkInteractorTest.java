package net.rdyonline.catclowder.randomcat;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import net.rdyonline.catclowder.BuildConfig;
import net.rdyonline.catclowder.R;
import net.rdyonline.catclowder.helper.BitmapHelper;
import net.rdyonline.catclowder.module.ContextModule;
import net.rdyonline.catclowder.networking.NetworkProvider;
import net.rdyonline.catclowder.reals.RealRandomCatPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.nio.ByteBuffer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RandomCatNetworkInteractorTest {

    @Mock
    NetworkProvider mMockNetworkProvider;
    @Mock
    Bitmap mMockBitmap;
    @Mock
    RandomCatPresenter mMockPresenter;

    private RandomCatNetworkInteractor mRandomCatNetworkInteractor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ContextModule.init(RuntimeEnvironment.application);

        when(mMockNetworkProvider.newCatImage()).thenReturn(mMockBitmap);

        mRandomCatNetworkInteractor = new RandomCatNetworkInteractor(mMockNetworkProvider);
    }

    @Test
    public void shouldLoadCatImage() {
        mRandomCatNetworkInteractor.loadImageAsync(mMockPresenter);

        verify(mMockPresenter).newImageAvailable(mMockBitmap);
    }

    @SuppressLint("NewApi")
    @Test
    public void shouldLoadDefaultImageIfNetworkCallFails() {
        // given
        when(mMockNetworkProvider.newCatImage()).thenThrow(Exception.class);
        RealRandomCatPresenter presenter = new RealRandomCatPresenter();
        Drawable fallbackDrawable = RuntimeEnvironment.application.getDrawable(R.drawable.cat);
        Bitmap fallbackBitmap = BitmapHelper.getBitmap(fallbackDrawable);

        // when
        mRandomCatNetworkInteractor.loadImageAsync(presenter);

        // then
        assertThat(asBytes(presenter.getBitmap()).array())
                .isEqualTo(asBytes(fallbackBitmap).array());
    }

    private ByteBuffer asBytes(Bitmap bitmap) {
        ByteBuffer buffer = ByteBuffer.allocate(bitmap.getHeight() * bitmap.getRowBytes());
        bitmap.copyPixelsToBuffer(buffer);

        return buffer;
    }

}