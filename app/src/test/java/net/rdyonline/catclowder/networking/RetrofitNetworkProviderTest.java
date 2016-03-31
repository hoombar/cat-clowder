package net.rdyonline.catclowder.networking;

import android.graphics.Bitmap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class RetrofitNetworkProviderTest {

    private RetrofitNetworkProvider mRetrofitNetworkProvider;

    @Mock
    Bitmap mMockBitmap;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        mRetrofitNetworkProvider = new RetrofitNetworkProvider(mMockBitmap);
    }

    @Test
    public void shouldNotReturnNullFromNewImage() {
        assertThat(mRetrofitNetworkProvider.newCatImage()).isNotNull();
    }

    @Test
    public void shouldShowPlaceHolderIfImageFails() {
        assertThat(mRetrofitNetworkProvider.newCatImage()).isEqualTo(mMockBitmap);
    }

}