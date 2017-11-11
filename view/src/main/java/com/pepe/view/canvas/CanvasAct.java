package com.pepe.view.canvas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.pepe.view.R;


public class CanvasAct extends Activity {

    private CanvasView myView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_canvas);
        myView = (CanvasView)findViewById(R.id.myView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        myView.setBitmap(bitmap);

        Intent intent = getIntent();
        if(intent != null){
            CanvasView.DrawMode drawMode = CanvasView.DrawMode.valueOf(intent.getIntExtra("drawMode", 0));
            myView.setDrawMode(drawMode);
        }

        //清屏方法一：
//        mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        //清屏方法二：
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        mCanvas.drawPaint(paint);
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myView != null){
            myView.destroy();
            myView = null;
        }
    }
}