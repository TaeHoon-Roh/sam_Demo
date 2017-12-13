package com.uxfac.sam_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public class PreviewDemo extends Activity {

    LayoutInflater controlInflater = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);

        FrameLayout rl = (FrameLayout) findViewById(R.id.re_2);

        CameraSurfaceView cs = new CameraSurfaceView(getApplicationContext());
        rl.addView(cs, 0);

        OverlayView ov = new OverlayView(getApplicationContext());
        rl.addView(ov, 1);


/*        OverlayView_IMG ovi = new OverlayView_IMG(getApplicationContext());
        rl.addView(ovi, 2);*/



        OverlayView_IMG_Copy ovic = new OverlayView_IMG_Copy(getApplicationContext());
        rl.addView(ovic, 2);

    }
}