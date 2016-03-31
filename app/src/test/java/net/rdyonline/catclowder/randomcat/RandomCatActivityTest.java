package net.rdyonline.catclowder.randomcat;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;

import net.rdyonline.catclowder.BuildConfig;
import net.rdyonline.catclowder.R;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RandomCatActivityTest {

    private RandomCatActivity mRandomCatActivity;
    private ImageView mImageView;
    private ProgressBar mProgressBar;

    @Mock
    Bitmap mMockImage;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mRandomCatActivity = Robolectric.buildActivity(RandomCatActivity.class).create().get();

        mImageView = (ImageView) mRandomCatActivity.findViewById(R.id.cat_image);
        mProgressBar = (ProgressBar) mRandomCatActivity.findViewById(R.id.progress_bar);
    }

    @Test
    public void shouldShowSpinnerIf() {
        mRandomCatActivity.imageLoading();

        Assertions.assertThat(mImageView).isNotVisible();
        Assertions.assertThat(mProgressBar).isVisible();
    }

    @Test
    public void shouldShowImageWhenReady() {
        mRandomCatActivity.changeImage(mMockImage);

        Assertions.assertThat(mImageView).isVisible();
        Assertions.assertThat(mProgressBar).isNotVisible();
    }
}