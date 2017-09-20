package jp.techacademy.kusumi.daiju.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1, editText2;
    Button buttonPlus, buttonMinus, buttonMultiple, buttonDivide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMultiple = (Button) findViewById(R.id.buttonMultiple);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiple.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        double number01 = Double.parseDouble(editText1.getText().toString());
        double number02 = Double.parseDouble(editText2.getText().toString());

        String formula = null; //数式の文字列取得用
        double result = 0; //計算結果格納用



        if (id == R.id.buttonPlus) {
            formula =  String.valueOf(number01) + " ＋ " + String.valueOf(number02);
            result = (number01 + number02);
        } else if (id == R.id.buttonMinus) {
            formula =  String.valueOf(number01) + " − " + String.valueOf(number02);
            result = (number01 - number02);
        } else if (id == R.id.buttonMultiple) {
            formula =  String.valueOf(number01) + " × " + String.valueOf(number02);
            result =  (number01 * number02);
        } else if (id == R.id.buttonDivide) {
            formula =  String.valueOf(number01) + " ÷ " + String.valueOf(number02);
            result = (number01 / number02);
        }

        Intent intent = new Intent(this, CalculationActivity.class);
        intent.putExtra(getString(R.string.intent_key_formula), formula);
        intent.putExtra(getString(R.string.intent_key_calc), result);
        startActivity(intent);

    }
}

