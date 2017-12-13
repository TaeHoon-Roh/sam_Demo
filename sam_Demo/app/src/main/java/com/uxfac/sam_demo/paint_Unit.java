package com.uxfac.sam_demo;

import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by root on 17. 12. 12.
 */

public class paint_Unit {

    public Paint SEARCH_paint;
    public Paint NON_SEARCH_paint;
    public Paint ING_paint;
    public Paint ROADING_paint;
    public Paint INSERT_paint;

    public paint_Unit(){
        this.SEARCH_paint = init_s_paint();
        this.NON_SEARCH_paint = init_ns_paint();
        this.ING_paint = init_ing_paint();
        this.ROADING_paint = init_roading_paint();
        this.INSERT_paint = init_insert_paint();
    }

    private Paint init_s_paint(){
        Paint result = new Paint();

        result.setStyle(Paint.Style.STROKE);
        result.setColor(Color.GREEN);
        result.setStrokeWidth(10);

        return result;
    }

    private Paint init_ns_paint(){
        Paint result = new Paint();

        result.setStyle(Paint.Style.STROKE);
        result.setColor(Color.RED);
        result.setStrokeWidth(8);

        return result;
    }

    private Paint init_ing_paint(){
        Paint result = new Paint();

        result.setStyle(Paint.Style.FILL);
        result.setColor(Color.BLUE);
        result.setStrokeWidth(5);

        return result;
    }

    private Paint init_roading_paint(){
        Paint result = new Paint();

        result.setStyle(Paint.Style.STROKE);
        result.setColor(Color.YELLOW);
        result.setStrokeWidth(5);

        return result;
    }

    private Paint init_insert_paint(){
        Paint result = new Paint();

        result.setStyle(Paint.Style.STROKE);
        result.setColor(Color.WHITE);
        result.setStrokeWidth(10);

        return result;
    }


}
