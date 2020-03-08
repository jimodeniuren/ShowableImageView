package com.qqzzyy.showableimageview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;

import java.util.Objects;

public class ShowActivity extends AppCompatActivity {

    ShowView showView;
    private DisplayMetrics dm;
    Bitmap bitmap;
    byte[] bis ;
    float PaddingX;
    float PaddingY;
    float X ;
    float Y ;
    TranslateAnimation outAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        dm = getResources().getDisplayMetrics();
        X = getIntent().getFloatExtra("X",0);
        Y = getIntent().getFloatExtra("Y",0);
        bis = getIntent().getByteArrayExtra("bitmap");
        bitmap = BitmapFactory.decodeByteArray(bis, 0, Objects.requireNonNull(bis).length);
        showView = (ShowView)findViewById(R.id.show_dialog);
        showView.setImageBitmap(bitmap);
        showView.setupView();
        TranslateAnimation translateAnimation = new TranslateAnimation(X - ((float)(dm.widthPixels) - showView.getWidth())/2,0,
                Y - ((float)(dm.heightPixels)-showView.getHeight())/2,0);
        translateAnimation.setDuration(500);
        showView.startAnimation(translateAnimation);
        outAnimation = new TranslateAnimation(0,X - ((float)(dm.widthPixels) - showView.getWidth())/2,
                0,Y - ((float)(dm.heightPixels)-showView.getHeight())/2);
        outAnimation.setDuration(400);
        outAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                showView.matrix.postTranslate(X - ((float)(dm.widthPixels) - showView.getWidth())/2,
                        Y - ((float)(dm.heightPixels)-showView.getHeight())/2);
                showView.startAnimation(outAnimation);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
