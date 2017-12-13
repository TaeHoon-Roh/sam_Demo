package com.uxfac.sam_demo;

/**
 * Created by root on 17. 12. 12.
 */

public class Unit {

    public static int view_width;
    public static int view_height;
    public static boolean FaceDetectFlag;
    public static int face_width;
    public static int face_height;
    public static float re_x;
    public static float re_y;
    public static boolean first_end_flag;
    public Unit(){
        this.view_width = 0;
        this.view_height = 0;
        this.FaceDetectFlag = false;
        this.face_width = this.view_width/2;
        this.face_height = this.view_height/2;
        this.re_x = (float)0.96;
        this.re_y = (float)0.54;
        this.first_end_flag = false;

    }

}
