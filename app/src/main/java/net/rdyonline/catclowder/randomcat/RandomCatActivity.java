package net.rdyonline.catclowder.randomcat;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import net.rdyonline.catclowder.R;

public class RandomCatActivity extends AppCompatActivity implements RandomCatView, View.OnClickListener {

    private ImageView mImageView;
    private RandomCatPresenterImpl mRandomCatPresenter;
    private ProgressBar mProgressBar;

    public RandomCatActivity() {
        mRandomCatPresenter = new RandomCatPresenterImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (ImageView) findViewById(R.id.cat_image);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mImageView.setOnClickListener(this);

        mRandomCatPresenter.requestNewImage();
    }

    @Override
    public void imageLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
        mImageView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeImage(Bitmap image) {
        mProgressBar.setVisibility(View.INVISIBLE);
        mImageView.setVisibility(View.VISIBLE);

        mImageView.setImageBitmap(image);
    }

    @Override
    public void onClick(View v) {
        mRandomCatPresenter.requestNewImage();
    }
}
