package net.rdyonline.catclowder.randomcat;

import android.graphics.Bitmap;
import android.os.AsyncTask;

import net.rdyonline.catclowder.R;
import net.rdyonline.catclowder.helper.BitmapHelper;
import net.rdyonline.catclowder.networking.NetworkProvider;

import static net.rdyonline.catclowder.module.ResourceModule.drawableRes;

public class RandomCatNetworkInteractor implements RandomCatInteractor {

    private final NetworkProvider mNetworkProvider;

    public RandomCatNetworkInteractor(NetworkProvider networkProvider) {
        mNetworkProvider = networkProvider;
    }

    @Override
    public void loadImageAsync(RandomCatPresenter presenter) {
        new LoadImageTask(presenter).execute();
    }

    private class LoadImageTask extends AsyncTask<Void, Void, Bitmap> {

        private final RandomCatPresenter mPresenter;

        public LoadImageTask(RandomCatPresenter presenter) {
            mPresenter = presenter;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap;
            try {
                bitmap = mNetworkProvider.newCatImage();
            } catch (Exception e) {
                bitmap = BitmapHelper.getBitmap(drawableRes(R.drawable.cat));
            }

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mPresenter.newImageAvailable(bitmap);
        }
    }
}
