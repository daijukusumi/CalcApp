package jp.techacademy.kusumi.daiju.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    EditText editText1, editText2;
    Button buttonPlus, buttonMinus, buttonMultiple, buttonDivide;

    private BigDecimal number01, number02;



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

        editText1.addTextChangedListener(this);
        editText2.addTextChangedListener(this);

        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiple.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);

        buttonPlus.setEnabled(false);
        buttonMinus.setEnabled(false);
        buttonMultiple.setEnabled(false);
        buttonDivide.setEnabled(false);

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        number01 = new BigDecimal(editText1.getText().toString());
        number02 = new BigDecimal(editText2.getText().toString());

        String formula = null; //数式の文字列取得用
        BigDecimal result = new BigDecimal("0");

        if (id == R.id.buttonPlus) {
            formula =  String.valueOf(number01) + " ＋ " + String.valueOf(number02);
            result = number01.add(number02);
        } else if (id == R.id.buttonMinus) {
            formula =  String.valueOf(number01) + " − " + String.valueOf(number02);
            result = number01.subtract(number02);
        } else if (id == R.id.buttonMultiple) {
            formula =  String.valueOf(number01) + " × " + String.valueOf(number02);
            result =  number01.multiply(number02);
        } else if (id == R.id.buttonDivide) {
            formula =  String.valueOf(number01) + " ÷ " + String.valueOf(number02);
            result = number01.divide(number02, 1, BigDecimal.ROUND_HALF_UP);
        }

        Intent intent = new Intent(this, CalculationActivity.class);
        intent.putExtra(getString(R.string.intent_key_formula), formula);
        intent.putExtra(getString(R.string.intent_key_calc), String.valueOf(result));
        startActivity(intent);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if (editText1.getText().length() == 0|| editText2.getText().length() == 0) {
            buttonPlus.setEnabled(false);
            buttonMinus.setEnabled(false);
            buttonMultiple.setEnabled(false);
            buttonDivide.setEnabled(false);

        } else if (new BigDecimal(editText2.getText().toString()).compareTo(BigDecimal.ZERO) == 0) {
            buttonPlus.setEnabled(true);
            buttonMinus.setEnabled(true);
            buttonMultiple.setEnabled(true);
            buttonDivide.setEnabled(false);
            Log.d("ANDROID", String.valueOf(number02)+"b");
        } else {
            buttonPlus.setEnabled(true);
            buttonMinus.setEnabled(true);
            buttonMultiple.setEnabled(true);
            buttonDivide.setEnabled(true);
            Log.d("ANDROID", String.valueOf(number02)+"c");
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

