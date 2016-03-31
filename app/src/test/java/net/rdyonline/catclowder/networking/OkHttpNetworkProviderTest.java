package net.rdyonline.catclowder.networking;

import android.graphics.Bitmap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class OkHttpNetworkProviderTest {

    private OkHttpNetworkProvider mOkHttpNetworkProvider;

    @Mock
    Bitmap mMockBitmap;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mOkHttpNetworkProvider = new OkHttpNetworkProvider(mMockBitmap);
    }

    @Test
    public void shouldNotReturnNullFromNewImage() {
        assertThat(mOkHttpNetworkProvider.newCatImage()).isNotNull();
    }

    @Test
    public void shouldShowPlaceHolderIfImageFails() {
        assertThat(mOkHttpNetworkProvider.newCatImage()).isEqualTo(mMockBitmap);
    }

}