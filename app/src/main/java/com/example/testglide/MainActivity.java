package com.example.testglide;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RequestBuilder<PictureDrawable> requestBuilder;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imageView);
        requestBuilder =
                GlideApp.with(this)
                        .as(PictureDrawable.class)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_background)
                        .listener(new SvgSoftwareLayerSetter());
    }

    @Override
    protected void onStart() {
        super.onStart();
        reload();
    }
    private void reload() {
        Log.w(TAG, "reloading");
        loadNet();
    }
    private void loadNet() {
        Uri uri = Uri.parse("https://raw.githubusercontent.com/aditya-dk7/temp/master/1625492313painted-flag-of-Catalonia.svg");
        requestBuilder.load(uri).into(image);
    }
}