package com.example.exp2task2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numberInput;
    private RadioGroup optionGroup;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        optionGroup = findViewById(R.id.optionGroup);
        Button submitButton = findViewById(R.id.submitButton);
        resultText = findViewById(R.id.resultText);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void calculateResult() {
        String inputText = numberInput.getText().toString();
        if (inputText.isEmpty()) {
            resultText.setText("Please enter a number.");
            return;
        }

        int number = Integer.parseInt(inputText);
        int selectedId = optionGroup.getCheckedRadioButtonId();
        RadioButton selectedOption = findViewById(selectedId);

        if (selectedOption == null) {
            resultText.setText("Please select an option.");
            return;
        }

        String result = "";
        if (selectedOption.getId() == R.id.radioFactorial) {
            result = "Factorial: " + factorial(number);
        }
        else if (selectedOption.getId() == R.id.radioEvenOdd) {
            if(number==0){
                result="The number is neither even nor odd";

            } else {
                result = number % 2 == 0 ? "The number is Even." : "The number is Odd.";
            }

        }


        resultText.setText(result);
    }

    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
