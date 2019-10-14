package com.vincentz.twocircles_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int radius1, radius2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.ma_btShowCircles);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText ed_radius1 = findViewById(R.id.ma_etRadiusOne);
                EditText ed_radius2 = findViewById(R.id.ma_etRadiusTwo);

                try {
                    radius1 = Integer.parseInt(ed_radius1.getText().toString());
                    radius2 = Integer.parseInt(ed_radius2.getText().toString());
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    return;
                }

                RadioGroup radioGroup1 = findViewById(R.id.ma_rgOne);
                RadioGroup radioGroup2 = findViewById(R.id.ma_rgTwo);
                int selectedId1 = radioGroup1.getCheckedRadioButtonId();
                int selectedId2 = radioGroup2.getCheckedRadioButtonId();
                RadioButton radioButton1 = findViewById(selectedId1);
                RadioButton radioButton2 = findViewById(selectedId2);
                String colorText1 = ((String) radioButton1.getText());
                String colorText2 = ((String) radioButton2.getText());

                Intent intent = new Intent(MainActivity.this, CirclesActivity.class);
                intent.putExtra("Circle1Radius", radius1);
                intent.putExtra("Circle2Radius", radius2);
                intent.putExtra("Circle1Color", colorText1);
                intent.putExtra("Circle2Color", colorText2);

                startActivity(intent);
            }
        });
    }
}
