package jp.techacademy.kusumi.daiju.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CalculationActivity extends AppCompatActivity {

    TextView textViewCalc1, textViewCalc2;
    String formula;
    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        textViewCalc1 = (TextView) findViewById(R.id.textViewCalc1);
        textViewCalc2 = (TextView) findViewById(R.id.textViewCalc2);

        Intent intent = getIntent();

        formula = intent.getStringExtra(getString(R.string.intent_key_formula));
        result = intent.getStringExtra(getString(R.string.intent_key_calc));

        textViewCalc1.setText(formula);
        textViewCalc2.setText(String.valueOf(result));


    }
}

