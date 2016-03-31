package net.rdyonline.catclowder.networking;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;

import net.rdyonline.catclowder.BuildConfig;
import net.rdyonline.catclowder.R;
import net.rdyonline.catclowder.fakes.FakeOkHttpCall;
import net.rdyonline.catclowder.helper.BitmapHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okio.BufferedSource;
import okio.Okio;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class OkHttpNetworkProviderTest {

    private OkHttpNetworkProvider mOkHttpNetworkProvider;

    @Mock
    Bitmap mMockFallbackBitmap;

    @Mock
    OkHttpClient mOkHttpClient;
    private FakeOkHttpCall mFakeOkHttpCall;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mFakeOkHttpCall = new FakeOkHttpCall();
        Bitmap bitmap = BitmapHelper.getBitmap(RuntimeEnvironment.application.getDrawable(R.drawable.cat));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());
        BufferedSource pngSource = Okio.buffer(Okio.source(in));

        mFakeOkHttpCall.setResponseBody(pngSource, baos.size());

        when(mOkHttpClient.newCall(any(Request.class))).thenReturn(mFakeOkHttpCall);
        mOkHttpNetworkProvider = new OkHttpNetworkProvider(mMockFallbackBitmap, mOkHttpClient);
    }

    @Test
    public void shouldNotReturnNullFromNewImage() {
        Bitmap actual = mOkHttpNetworkProvider.newCatImage();

        assertThat(actual).isNotNull();
        assertThat(actual).isNotEqualTo(mMockFallbackBitmap);
    }

    @Test
    public void shouldShowPlaceHolderIfImageFails() {
        mFakeOkHttpCall.setResponseBody(null, 0);

        assertThat(mOkHttpNetworkProvider.newCatImage()).isEqualTo(mMockFallbackBitmap);
    }

}