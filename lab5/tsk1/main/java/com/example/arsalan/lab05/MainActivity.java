package com.example.arsalan.lab05;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.TextView;

import static android.view.MotionEvent.actionToString;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener
{
    GestureDetectorCompat gestureDetectorCompat;
    TextView gesture;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gesture = findViewById(R.id.textView3);
        gestureDetectorCompat = new GestureDetectorCompat(this,this);
        gestureDetectorCompat.setIsLongpressEnabled(true);


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public  boolean onTouchEvent (MotionEvent e) {

        if(e.getPointerCount() > 1){
            gesture.setText("Multi Touch\nEvent");
            int action = e.getAction();
            int index = e.getActionIndex();
            gesture.append("\n"+ actionToString(action)+"\n Pointer Index: "+index);   }

        gestureDetectorCompat.onTouchEvent(e);
        return super.onTouchEvent(e);
    }

    @Override
    public boolean onSingleTapConfirmed( MotionEvent e ) {
        gesture.setText("Single Tap");
        return true;
    }

    @Override
    public boolean onDoubleTap( MotionEvent e ) {
        gesture.setText("Double Tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent( MotionEvent e ) {
        gesture.setText("Double Tap Event");
        return true;
    }

    @Override
    public boolean onDown( MotionEvent e ) {
        gesture.setText("Down");
        return true;
    }

    @Override
    public void onShowPress( MotionEvent e ) {
        gesture.setText("Show Press");
    }


    @Override
    public boolean onSingleTapUp( MotionEvent e ) {
        gesture.setText("Single Tap Up");
        return true;
    }

    @Override
    public boolean onScroll( MotionEvent e1, MotionEvent e2, float distanceX, float distanceY ) {
        gesture.setText("Scroll");
        return true;
    }

    @Override
    public void onLongPress( MotionEvent e ) {
        gesture.setText("Lomg Press"); }


    @Override
    public boolean onFling( MotionEvent e1, MotionEvent e2, float velocityX, float velocityY ) {
        gesture.setText("Fling");
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    }

}

