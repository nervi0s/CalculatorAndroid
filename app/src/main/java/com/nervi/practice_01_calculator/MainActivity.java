package com.nervi.practice_01_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1Input;
    EditText number2Input;
    EditText operationInput;
    TextView resultShower;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1Input = findViewById(R.id.number1);
        number2Input = findViewById(R.id.number2);
        operationInput = findViewById(R.id.operacion);
        resultShower = findViewById(R.id.result);
        Button action = findViewById(R.id.calculate);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation();
            }
        });
    }

    public void operation() {
        String operation = this.operationInput.getText().toString().trim();
        String number1Content = number1Input.getText().toString();
        String number2Content = number2Input.getText().toString();
        boolean isNumber1ContentEmpty = TextUtils.isEmpty(number1Content);
        boolean isNumber2ContentEmpty = TextUtils.isEmpty(number2Content);
        boolean isOperationEmpty = TextUtils.isEmpty(operation);
        double res;

        if (isNumber1ContentEmpty || isNumber2ContentEmpty) {
            resultShower.setText("Debe introducir\nambos números");
            if (isNumber1ContentEmpty) {
                number1Input.setError("No puede estar vacío");
            }
            if (isNumber2ContentEmpty) {
                number2Input.setError("No puede estar vacío");
            }
        } else {
            if (isOperationEmpty) {
                resultShower.setText("Debe introducir\nuna operación");
            } else {
                double n1 = Double.parseDouble(number1Input.getText().toString());
                double n2 = Double.parseDouble(number2Input.getText().toString());

                if (operation.equalsIgnoreCase("sumar")) {
                    res = n1 + n2;
                    resultShower.setText(String.valueOf(res));
                } else if (operation.equalsIgnoreCase("restar")) {
                    res = n1 - n2;
                    resultShower.setText(String.valueOf(res));
                } else if (operation.equalsIgnoreCase("multiplicar")) {
                    res = n1 * n2;
                    resultShower.setText(String.valueOf(res));
                } else if (operation.equalsIgnoreCase("dividir")) {
                    if (n2 == 0) {
                        number2Input.setError("No puedes dividir entre 0");
                    } else {
                        res = n1 / n2;
                        resultShower.setText(String.valueOf(res));
                    }
                } else {
                    resultShower.setText("Operación incorrecta");
                }
            }
        }
    }
}