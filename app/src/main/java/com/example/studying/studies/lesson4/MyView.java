package com.example.studying.studies.lesson4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.studying.studies.R;

public class MyView extends View {

    private Paint myPaint = new Paint();
    int cx, cy;

    //Какая-то область, к-ю мы ограничиваем
    private RectF arcRectF = new RectF();

    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        //сглаживает неровные пиксели
        myPaint.setAntiAlias(true);

        myPaint.setColor(ContextCompat.getColor(getContext(), R.color.buttonsColor));

        myPaint.setStyle(Paint.Style.FILL);

        //Из флоута в пиксели
        Resources r = getResources();
        float strokeWidthInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, r.getDisplayMetrics());
        //Устанавливаем ширину
        myPaint.setStrokeWidth(strokeWidthInPx);
    }

    //Метод вызывается при изменении размеров
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    //Определяет начальные размеры View
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }



    //Использовать аккуратно, без тяжелых и многочисленных действий
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = Math.min(getWidth(), getHeight())/4;
        canvas.drawCircle(cx, cy, radius, myPaint);

        /*int startX = 0;
        int startY = 0;
        int stopX = getWidth();
        int stopY = getHeight();

        canvas.drawLine(startX, startY, stopX, stopY, myPaint);

        arcRectF.left = 0;
        arcRectF.top = 0;
        arcRectF.right = getWidth();
        arcRectF.bottom = getHeight();
        canvas.drawArc(arcRectF, 0, 90, true, myPaint);

        canvas.drawRect(50, 50, 100, 100, myPaint);*/
    }

    //Ловит все клики на экран
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_MOVE){
            cx = (int)event.getX();
            cy = (int)event.getY();
            //аставляет экран перерисоваться
            invalidate();
        }
        return true;
    }
}
