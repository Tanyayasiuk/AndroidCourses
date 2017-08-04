package com.example.studying.studies.dz4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.example.studying.studies.R;


public class ClockView extends View {

    private Paint myClockPaint;
    private Paint myNumbersPaint;
    private Paint myBackgroundPaint;

    int hours, minutes, seconds;

    public ClockView(Context context, int hours, int minutes, int seconds) {
        super(context);
        init();
        this.hours = hours;
        this.minutes = minutes;
        this.seconds =  seconds;

    }

    public ClockView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init(){
        myClockPaint = new Paint();
        myClockPaint.setAntiAlias(true);
        myClockPaint.setColor(ContextCompat.getColor(getContext(), R.color.clockColor));
        myClockPaint.setStyle(Paint.Style.STROKE);

        Resources r = getResources();
        float strokeWidthInPxClock = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, r.getDisplayMetrics());
        float strokeWidthInPxN = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, r.getDisplayMetrics());

        myNumbersPaint = new Paint();
        myNumbersPaint.setAntiAlias(true);
        myNumbersPaint.setTextSize(getResources().getDimension(R.dimen.text_size));
        myNumbersPaint.setColor(ContextCompat.getColor(getContext(), R.color.numbersColor));
        myNumbersPaint.setStrokeWidth(strokeWidthInPxN);


        myClockPaint.setStrokeWidth(strokeWidthInPxClock);

        myBackgroundPaint = new Paint();
        myBackgroundPaint.setAntiAlias(true);
        myBackgroundPaint.setColor(ContextCompat.getColor(getContext(), R.color.backColor));
        myBackgroundPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int radius = Math.min(getWidth(), getHeight())/4;
        int cx = getWidth()/2;
        int cy = getHeight()/2;

        canvas.drawCircle(cx, cy, radius, myClockPaint);
        canvas.drawCircle(cx, cy, radius - myClockPaint.getStrokeWidth(), myBackgroundPaint );

        /*Напоминалка:
        canvas.drawLine(startX, startY, stopX, stopY, myPaint);*/

        for(int i = 0; i < 360; i+=30){
            if (i%90!=0)
                canvas.drawLine(cx, cy-radius, cx, (cy-radius) + 50, myNumbersPaint);
           /* //Вариант, чтобы цифры проставились сами, но тут вопрос  с ориентацией 3 и 9
            else{
                String number;
                switch (i){
                    case 0:
                        number = "12";
                        break;
                    case 90:
                        number = " 3";
                        break;
                    case 180:
                        number = " 9";
                        break;
                    case 270:
                        number = " 9";
                        break;
                    default:
                        number = "0";
                }
                canvas.drawText(number, cx - myNumbersPaint.getTextSize()/2, cy-radius + myNumbersPaint.getTextSize(), myNumbersPaint);
            }*/

            canvas.rotate(30, cx, cy);
        }

        //Риосвание цифр "от руки". Многобукв, зато более-менее ровно и прямо
        canvas.drawText("12", cx - myNumbersPaint.getTextSize()/2, cy-radius + myNumbersPaint.getTextSize(), myNumbersPaint);
        canvas.drawText(" 9", cx - radius, cy + myNumbersPaint.getTextSize()/2, myNumbersPaint);
        canvas.drawText(" 3", cx + radius - myNumbersPaint.getTextSize(), cy + myNumbersPaint.getTextSize()/2, myNumbersPaint);
        canvas.drawText(" 6", cx - myNumbersPaint.getTextSize()/2, cy + radius - myNumbersPaint.getTextSize()/3, myNumbersPaint);

        int cur_hour = hours;
        if (cur_hour > 12){
            cur_hour = cur_hour - 12;
        }

        canvas.rotate(30 * cur_hour, cx, cy);
        canvas.drawLine(cx, cy, cx+radius/2.2f, cy, myClockPaint);
        canvas.rotate(-30 * cur_hour, cx, cy);

        canvas.rotate(6 * minutes, cx, cy);
        canvas.drawLine(cx, cy, cx, cy-radius/1.5f, myClockPaint);
        canvas.rotate(-6 * minutes, cx, cy);
        //вместо этого - метод restore

        canvas.rotate(6 * seconds, cx, cy);
        canvas.drawLine(cx, cy, cx, cy-radius, myNumbersPaint);
        canvas.rotate(-6 * seconds, cx, cy);

    }


}
