package com.uxfac.sam_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

/**
 * Created by root on 17. 12. 12.
 */

public class OverlayView extends View {

    private TutorialThread _thread;

    public static int left, right;

    paint_Unit p;

    public OverlayView(Context context) {
        super(context);

        p = new paint_Unit();
        _thread = new TutorialThread();
        _thread.start();

    }

    private void road_DrawFocusRect(float RectLeft, float RectTop, float RectRight, float RectBottom, Canvas canvas) {

        Paint paint = p.ROADING_paint;
        canvas.drawRect(RectLeft, RectTop, RectRight, RectBottom, paint);
    }

    private void search_DrawFocusRect(float RectLeft, float RectTop, float RectRight, float RectBottom, Canvas canvas) {

        Paint paint = p.SEARCH_paint;
        canvas.drawRect(RectLeft, RectTop, RectRight, RectBottom, paint);
        Bitmap temp, resize;

        //stage 1
        //temp = BitmapFactory.decodeResource(getResources(), R.drawable.success);
        //stage 2
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.lock);
        resize = Bitmap.createScaledBitmap(temp, 1000, 400, true);
        canvas.drawBitmap(resize,Unit.view_width/2 -500, Unit.view_height / 2 - 450, null);
        Log.i("tag","Unit.view_width/2 : " + Unit.view_width/2);
    }

    private void non_search_DrawFocusRect(float RectLeft, float RectTop, float RectRight, float RectBottom, Canvas canvas) {

        Paint paint = p.NON_SEARCH_paint;
        canvas.drawRect(RectLeft, RectTop, RectRight, RectBottom, paint);
        Bitmap temp, resize;
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.unlock);
        resize = Bitmap.createScaledBitmap(temp, 1000, 400, true);
        canvas.drawBitmap(resize,Unit.view_width/2 -500, Unit.view_height / 2 -450, null);
    }

    private void ing_DrawFocusRect(float RectLeft, float RectTop, float RectRight, float RectBottom, Canvas canvas) {

        Paint paint = p.ING_paint;
        canvas.drawRect(RectLeft, RectTop, RectRight, RectBottom, paint);
    }

    private void insert_DrawFocusRect(float RectLeft, float RectTop, float RectRight, float RectBottom, Canvas canvas) {

        Paint paint = p.INSERT_paint;
        canvas.drawRect(RectLeft, RectTop, RectRight, RectBottom, paint);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float RectLeft;
        float RectTop;
        float RectRight;
        float RectBottom;
        RectLeft = Unit.view_width / 2 - 350;
        RectTop = Unit.view_height / 2 - 600;
        RectRight = Unit.view_width / 2 + 350;
        RectBottom = Unit.view_height / 2 + 300;
        //Log.i("onDraw", " Unit.FaceDetectFlag : " + Unit.FaceDetectFlag);


        if (Unit.FaceDetectFlag == true) {
            road_DrawFocusRect(RectLeft, RectTop, RectRight, RectBottom, canvas);
            if (Unit.first_end_flag == true) {
                //search
                //search_DrawFocusRect(RectLeft, RectTop, RectRight, RectBottom, canvas);
                //error
                non_search_DrawFocusRect(RectLeft, RectTop, RectRight, RectBottom, canvas);
            } else {
                road_DrawFocusRect(RectLeft, RectTop, RectRight, RectBottom, canvas);
            }
        } else {
            road_DrawFocusRect(RectLeft, RectTop, RectRight, RectBottom, canvas);
        }
    }

    class TutorialThread extends Thread {
        Canvas canvas;

        public TutorialThread() {
            canvas = new Canvas();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    postInvalidate();
                    Thread.sleep(300);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
    }

}
