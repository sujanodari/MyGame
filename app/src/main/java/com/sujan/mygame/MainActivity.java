package com.sujan.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btnFirst, btnSecond;
    private TextView tvResult;

    private int num1, num2, result, rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        tvResult = findViewById(R.id.tvResult);

        setBtnNumber();
        setNumber();

            btnFirst.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (compare(num1, num2)) {
                        result = result + 1;
                        tvResult.setText("result is " + result);
                    } else {
                        result = result - 1;
                        tvResult.setText("result is " + result);
                    }
                    setBtnNumber();
                    setNumber();
                    declare();
                }
            });

            btnSecond.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (compare(num1, num2)) {
                        result = result - 1;
                        tvResult.setText("result is " + result);
                    } else {
                        result = result + 1;
                        tvResult.setText("result is " + result);
                    }
                    setBtnNumber();
                    setNumber();
                    declare();

                }
            });



    }


    public boolean compare(int x, int y) {
        if (x > y) {
            return true;
        } else {
            return false;
        }
    }


    public void setBtnNumber() {
        btnFirst.setText(Integer.toString(getRand()));
        btnSecond.setText(Integer.toString(getRand()));


    }

    private int getRand() {
        Random rand = new Random();
        int value = rand.nextInt(100);
        return value;
    }

    public void setNumber() {
        num1 = Integer.parseInt(btnFirst.getText().toString());
        num2 = Integer.parseInt(btnSecond.getText().toString());
    }

    public void declare() {
        if (result < 10 || result > -10) {

        }
            if (result == 10) {
                Toast.makeText(this, "You are Winner", Toast.LENGTH_SHORT).show();
            }
            if (result == -10) {
                Toast.makeText(this, "You are Looser", Toast.LENGTH_SHORT).show();
            }


    }


}
