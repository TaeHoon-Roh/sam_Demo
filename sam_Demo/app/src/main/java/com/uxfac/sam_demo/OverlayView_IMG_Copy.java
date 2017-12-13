package com.uxfac.sam_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by root on 17. 12. 12.
 */

public class OverlayView_IMG_Copy extends View {
    Context context;

    Bitmap temp = null, resize = null;
    Bitmap temp_null = null, resize_null = null;
    int bitmap_size = 600;
    TutorialThread _thread;
    int count = 0;
    int left = 0;
    int bottom = 0;

    public OverlayView_IMG_Copy(Context context) {
        super(context);

        this.left = Unit.view_width / 2 + 370;
        this.bottom = Unit.view_height / 2 + 300;

        temp = BitmapFactory.decodeResource(getResources(), R.drawable.block);
        resize = Bitmap.createScaledBitmap(temp, 70, 25, true);

        _thread = new TutorialThread();
        _thread.start();

    }

    private void input_block(Canvas canvas) {
        Paint p = new paint_Unit().ING_paint;

        for (int i = 0; i < count; i++) {
            canvas.drawBitmap(resize, left, bottom - i * 50, null);
        }
    }

    private void input_null_block(Canvas canvas) {
        for (int i = 0; i < 20; i++) {
            canvas.drawBitmap(resize_null, left, bottom - i * 50, null);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (Unit.FaceDetectFlag == true) {
            input_block(canvas);
        } else {
            input_block(canvas);
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
                    if (Unit.first_end_flag == false) {
                        if (Unit.FaceDetectFlag == true) {
                            count++;
                            if (count == 20) {
                                count = 0;
                                Unit.first_end_flag = true;
                                break;
                            }
                            postInvalidate();
                            Thread.sleep(50);
                        } else {
                            postInvalidate();
                            Thread.sleep(50);
                        }

                    } else {
                        postInvalidate();
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        }
    }

}
