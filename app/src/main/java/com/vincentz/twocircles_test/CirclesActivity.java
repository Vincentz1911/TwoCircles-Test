package com.vincentz.twocircles_test;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;

public class CirclesActivity extends AppCompatActivity {

    private String color1, color2;
    private int radius1, radius2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circles);

        radius1 = getIntent().getIntExtra("Circle1Radius", 0);
        radius2 = getIntent().getIntExtra("Circle2Radius", 0);
        color1 = getIntent().getStringExtra("Circle1Color");
        color2 = getIntent().getStringExtra("Circle2Color");

        int orange = Color.parseColor("#FFA500");

        Paint paint1 = new Paint();
        switch (color1)
        {
            case "Red" : paint1.setColor(Color.RED); break;
            case "Green" : paint1.setColor(Color.GREEN);break;
            case "Blue" :  paint1.setColor(Color.BLUE);break;
            case "Orange" : paint1.setColor(orange);break;
        }

        Paint paint2 = new Paint();
        switch (color2)
        {
            case "Cyan" : paint2.setColor(Color.CYAN);break;
            case "Magenta" : paint2.setColor(Color.MAGENTA);break;
            case "Grey" :  paint2.setColor(Color.GRAY);break;
            case "Black" : paint2.setColor(Color.BLACK);break;
        }

        LinearLayout linearLayout = findViewById(R.id.lin_graphics);
        linearLayout.addView(new CircleGraphics(this, radius1, radius2, paint1, paint2));
    }
}