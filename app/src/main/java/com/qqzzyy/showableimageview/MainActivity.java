package com.qqzzyy.showableimageview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowableImageView showableImageView = (ShowableImageView)findViewById(R.id.showable_image_view);
        Bitmap rawBitmap = BitmapFactory.decodeResource(getResources(),R.drawable.test);
        showableImageView.setImageBitmap(rawBitmap);

        ShowableImageView showableImageView2 = (ShowableImageView)findViewById(R.id.showable_image_view_2);
        Bitmap rawBitmap2 = BitmapFactory.decodeResource(getResources(),R.drawable.test2);
        showableImageView2.setImageBitmap(rawBitmap2);
    }
}
