package com.qqzzyy.showableimageview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

@SuppressLint("AppCompatCustomView")
public class ShowableImageView extends ImageView {

    Bitmap sourceBitmap;
    Dialog dialog = new Dialog(getContext());
    ShowView showView = new ShowView(getContext());
    float X;
    float Y;
    float height;
    float width;
    ShowableImageView showableImageView = ShowableImageView.this;

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        sourceBitmap = bitmap;
    }

    public ShowableImageView(final Context context, @Nullable AttributeSet attrs) throws InterruptedException {
        super(context, attrs);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ShowActivity.class);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                X = showableImageView.getLeft();
                Y = showableImageView.getTop();
                height = showableImageView.getHeight();
                width = showableImageView.getWidth();
                sourceBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] bitmapByte = baos.toByteArray();
                intent.putExtra("bitmap",bitmapByte);
                intent.putExtra("X",X);
                intent.putExtra("Y",Y);
                intent.putExtra("height",height);
                intent.putExtra("width",width);
                context.startActivity(intent);
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
//                @SuppressLint("InflateParams")
//                View v2 =  Objects.requireNonNull(inflater).inflate(R.layout.dialog_show,null);
//                showView = (ShowView)v2.findViewById(R.id.show_dialog);
//                showView.setImageBitmap(sourceBitmap);
//
//                dialog.setContentView(v2);
//                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
//                            @Override
//                            public void onCancel(DialogInterface dialog) {
//                                ScaleAnimation scaleAnimation=new ScaleAnimation(1.0f,0.5f,1.0f,0.5f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                                scaleAnimation.setDuration(200);
//                                startAnimation(scaleAnimation);
//                            }
//                        });
//                dialog.show();
//                final WindowManager.LayoutParams params = Objects.requireNonNull(dialog.getWindow()).getAttributes();
//                params.width = sourceBitmap.getWidth();
//                params.height = sourceBitmap.getHeight();
//                dialog.getWindow().setAttributes(params);
//                Window win = dialog.getWindow();
//                Objects.requireNonNull(win).getDecorView().setPadding(0, 0, 0, 0);
//                WindowManager.LayoutParams lp = win.getAttributes();
//                lp.gravity = Gravity.CENTER;
//                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
//                lp.dimAmount = 1.0f;//阴影颜色
//                win.setAttributes(lp);
            }
        });
    }
}

