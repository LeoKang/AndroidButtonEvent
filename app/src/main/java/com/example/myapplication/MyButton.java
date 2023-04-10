package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {


    public MyButton(Context context) {
        super(context);

        init(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        setBackgroundColor(Color.CYAN);
        setTextColor(Color.BLACK);

        float textsize= getResources().getDimension(R.dimen.text_size);
        setTextSize(textsize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Log.d("MyButton","onDraw호출됨");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) { //버튼 터치 이벤트
        Log.d("MyButton","onTouchEvent호출됨");
        int action = event.getAction();

        switch(action){
            case MotionEvent.ACTION_DOWN: // 눌리면 text빨간색
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.RED);
                break;

            case MotionEvent.ACTION_OUTSIDE: // 다른 경우 그
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:  // 떄면 원복
                Log.d("MyButton","버튼땜");
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.BLACK);
                break;
        }

        // 화면을 다시 그려줌 onDraw 호출?
        invalidate();
        return true;
    }

}