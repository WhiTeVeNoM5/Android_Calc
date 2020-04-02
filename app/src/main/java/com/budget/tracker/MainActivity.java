package com.budget.tracker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    float sum = 0;
    String strFull = "";
    String strTemp = "0";
    String func = "add";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tempDisp = findViewById(R.id.tempDisp);
        final TextView fullDisp = findViewById(R.id.fullDisp);
        fullDisp.setText("0");

        Button bt1 = findViewById(R.id.one);
        Button bt2 = findViewById(R.id.two);
        Button bt3 = findViewById(R.id.three);
        Button bt4 = findViewById(R.id.four);
        Button bt5 = findViewById(R.id.five);
        Button bt6 = findViewById(R.id.six);
        Button bt7 = findViewById(R.id.seven);
        Button bt8 = findViewById(R.id.eight);
        Button bt9 = findViewById(R.id.nine);
        Button bt0 = findViewById(R.id.zero);
        Button btpt = findViewById(R.id.dot);
        Button bteq = findViewById(R.id.result);
        Button btadd = findViewById(R.id.add);
        Button btmul = findViewById(R.id.multiply);
        Button btdiv = findViewById(R.id.division);
        Button btsub = findViewById(R.id.sub);
        Button btclr = findViewById(R.id.clear);

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nullCheck(strFull)) {
                    strAdd("0");
                    fullDisp.setText(strFull);
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("1");
                fullDisp.setText(strFull);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("2");
                fullDisp.setText(strFull);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("3");
                fullDisp.setText(strFull);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("4");
                fullDisp.setText(strFull);
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("5");
                fullDisp.setText(strFull);
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("6");
                fullDisp.setText(strFull);
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("7");
                fullDisp.setText(strFull);
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("8");
                fullDisp.setText(strFull);
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd("9");
                fullDisp.setText(strFull);
            }
        });

        btpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strAdd(".");
                fullDisp.setText(strFull);
            }
        });

        btadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!strTemp.equals("0")) {
                    doCalc();
                    strAdd("+");
                    fullDisp.setText(strFull);
                    func = "add";
                    tempDisp.setText(removeTrZ(sum));
                }
            }
        });

        btmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!strTemp.equals("0")) {
                    doCalc();
                    strAdd("x");
                    fullDisp.setText(strFull);
                    func = "mul";
                    tempDisp.setText(removeTrZ(sum));
                }
            }
        });

        btdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!strTemp.equals("0")) {
                    doCalc();
                    strAdd("/");
                    fullDisp.setText(strFull);
                    func = "div";
                    tempDisp.setText(removeTrZ(sum));
                }
            }
        });

        btsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!strTemp.equals("0")) {
                    doCalc();
                    strAdd("-");
                    fullDisp.setText(strFull);
                    func = "sub";
                    tempDisp.setText(removeTrZ(sum));
                }
            }
        });

        bteq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doCalc();
                tempDisp.setText(removeTrZ(sum));

            }
        });

        btclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempDisp.setText("");
                fullDisp.setText("0");
                sum = 0;
                strFull = "";
                strTemp = "0";
                func = "add";
            }
        });

    }

    final public void strAdd(String s){
        strFull += s;
        if(!s.equals("+") && !s.equals("-") && !s.equals("/") && !s.equals("x")) strTemp += s;
    }

    public boolean nullCheck(String s){
        if(s.equals(null)) return false;
        return true;
    }

    public String removeTrZ(float f){
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(f);
    }

    public void doCalc(){
        if(func.equals("add")) sum += Float.parseFloat(strTemp);
        if(func.equals("sub")) sum -= Float.parseFloat(strTemp);
        if(func.equals("mul")) sum *= Float.parseFloat(strTemp);
        if(func.equals("div")) sum /= Float.parseFloat(strTemp);
        strTemp = "0";

    }
}