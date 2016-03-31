package net.rdyonline.catclowder.randomcat;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.rdyonline.catclowder.R;

public class RandomCatActivity extends AppCompatActivity implements RandomCatView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void imageLoading() {

    }

    @Override
    public void changeImage(Bitmap image) {

    }
}
