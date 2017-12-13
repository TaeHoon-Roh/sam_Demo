package com.uxfac.sam_demo;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by root on 17. 12. 11.
 */

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Camera.PreviewCallback {

    private SurfaceHolder previewHolder, previewHolderCopy = null;
    private Camera camera = null;

    Context context;

    CameraSurfaceView(Context context) {
        super(context);
        this.context = context;

        camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_FRONT);

        previewHolder = getHolder();
        previewHolder.addCallback(this);
        previewHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


        camera.setDisplayOrientation(90);

        Camera.Parameters params = camera.getParameters();

        params.set("orientation", "portrait");

        if (params.getMaxNumDetectedFaces() > 0) {
            camera.startFaceDetection();
            camera.setFaceDetectionListener(new FaceDetectionListener());
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(previewHolder);
            camera.setDisplayOrientation(90);

        } catch (Throwable t) {
            Log.e("PreviewDemo",
                    "Exception in setPreviewDisplay()", t);
            Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
    }

    private Camera.Size getBestPreviewSize(int width, int height, Camera.Parameters parameters) {
        Camera.Size result = null;
        for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
            if (size.width <= width && size.height <= height) {
                if (result == null) {
                    result = size;
                } else {
                    int resultArea = result.width * result.height;
                    int newArea = size.width * size.height;
                    if (newArea > resultArea) {
                        result = size;
                    }
                }
            }
        }
        return (result);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        Camera.Parameters parameters = camera.getParameters();
        Camera.Size size = getBestPreviewSize(width, height,
                parameters);

        if (size != null) {
            parameters.setPreviewSize(size.width, size.height);
            camera.setParameters(parameters);
            camera.startPreview();
        }

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void onPreviewFrame(byte[] data, Camera camera) {

    }

    private class FaceDetectionListener implements Camera.FaceDetectionListener {

        @Override
        public void onFaceDetection(Camera.Face[] faces, Camera camera) {

            if (faces.length > 0) {
                //Log.i("Face Detection", "face detected");
                int left = faces[0].rect.centerX();
                int top = faces[0].rect.centerY();
                int height = faces[0].rect.height();
                int width = faces[0].rect.width();
                //Log.i("FaceCheck", " left : " + left + " top : " + top);
                if(Unit.FaceDetectFlag == false) {
                    if((left > -100) && (left < 100) && ((top > -100) && (top < 100 ))) {
                        Unit.FaceDetectFlag = true;
                    }
                }

            } else {
                Unit.FaceDetectFlag = false;
            }
        }
    }

    class timer extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
