package com.uxfac.sam_demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by root on 17. 12. 12.
 */

public class OverlayView_IMG extends View {
    Context context;

    Bitmap temp = null, resize[] = null;
    int bitmap_size = 600;
    TutorialThread _thread;
    int count = 0;
    public OverlayView_IMG(Context context) {
        super(context);

        resize = new Bitmap[6];

        temp = BitmapFactory.decodeResource(getResources(), R.drawable.t_2_1);
        resize[0] = Bitmap.createScaledBitmap(temp, bitmap_size, bitmap_size, true);
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.t_2_2);
        resize[1] = Bitmap.createScaledBitmap(temp, bitmap_size, bitmap_size, true);
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.t_2_3);
        resize[2] = Bitmap.createScaledBitmap(temp, bitmap_size, bitmap_size, true);
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.t_3_1);
        resize[3] = Bitmap.createScaledBitmap(temp, bitmap_size, bitmap_size, true);
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.t_3_2);
        resize[4] = Bitmap.createScaledBitmap(temp, bitmap_size, bitmap_size, true);
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.t_3_3);
        resize[5] = Bitmap.createScaledBitmap(temp, bitmap_size, bitmap_size, true);
        temp = BitmapFactory.decodeResource(getResources(), R.drawable.t_null);

        _thread = new TutorialThread();
        _thread.start();

    }

    private void input_img(Canvas canvas) {
        if(Unit.first_end_flag == false) {
            if (Unit.FaceDetectFlag == true) {
                canvas.drawBitmap(resize[count], Unit.view_width / 2 - 290, Unit.view_height / 2 + 250, null);
            } else {
                canvas.drawBitmap(temp, Unit.view_width / 2 - 290, Unit.view_height / 2 + 250, null);
            }
        } else{
            canvas.drawBitmap(temp, Unit.view_width / 2 - 290, Unit.view_height / 2 + 250, null);
        }
    }
    @Override
    protected void onDraw(Canvas canvas){
        input_img(canvas);
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
                    if(Unit.first_end_flag == false) {
                        if (Unit.FaceDetectFlag == true) {
                            if (count == 6) {
                                Unit.first_end_flag = true;

                                count = 0;
                            } else {

                                postInvalidate();
                                Thread.sleep(1500);
                                Log.i("OverlayViewImg", "Count : " + count);
                                count++;
                            }
                        } else {
                            postInvalidate();
                            Thread.sleep(100);
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
