package com.vincentz.twocircles_test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class CircleGraphics extends View implements View.OnTouchListener {

    private int xOld, yOld;
    private boolean is1Moving = false, is2Moving = false;
    private Paint paint1, paint2;
    private int xCircle1 = 100, yCircle1 = 100, rCircle1;
    private int xCircle2 = 400, yCircle2 = 400, rCircle2;

    public CircleGraphics(Context context, int radius1, int radius2, Paint paint1, Paint paint2) {
        super(context);
        this.setOnTouchListener(this);

        rCircle1 = radius1;
        rCircle2 = radius2;
        this.paint1 = paint1;
        this.paint2 = paint2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(xCircle1, yCircle1, rCircle1, paint1);
        canvas.drawCircle(xCircle2, yCircle2, rCircle2, paint2);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        int touchX = (int) motionEvent.getX();
        int touchY = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:

                //CIRCLE 1
                if (touchX > (xCircle1 - rCircle1) && touchX < (xCircle1 + rCircle1) &&
                        touchY > (yCircle1 - rCircle1) && touchY < (yCircle1 + rCircle1)) {
                    is1Moving = true;
                    xOld = touchX;
                    yOld = touchY;
                }

                //CIRCLE 2
                if (touchX > (xCircle2 - rCircle2) && touchX < (xCircle2 + rCircle2) &&
                        touchY > (yCircle2 - rCircle2) && touchY < (yCircle2 + rCircle2)) {
                    is2Moving = true;
                    xOld = touchX;
                    yOld = touchY;
                }
                return true;

            case MotionEvent.ACTION_MOVE:

                //Circle 1
                if (is1Moving) {
                    xCircle1 += touchX - xOld;
                    yCircle1 += touchY - yOld;
                    xOld = touchX;
                    yOld = touchY;

                    invalidate();
                }

                //Circle 2
                if (is2Moving) {
                    xCircle2 += touchX - xOld;
                    yCircle2 += touchY - yOld;
                    xOld = touchX;
                    yOld = touchY;

                    invalidate();
                }
                return true;

            case MotionEvent.ACTION_UP:
                is1Moving = false;
                is2Moving = false;
                return true;
        }
        return false;
    }
}
