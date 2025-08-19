package vu.eduntu.randomcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView numberTextView, numberTextView2, resultTextView;
    private int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberTextView = findViewById(R.id.numberTextView);
        numberTextView2 = findViewById(R.id.numberTextView2);
        resultTextView = findViewById(R.id.resultTextView);

        Button generateButton = findViewById(R.id.generateButton);
        ImageButton additionButton = findViewById(R.id.additionButton);
        ImageButton subtractionButton = findViewById(R.id.subtractionButton);
        ImageButton multiplicationButton = findViewById(R.id.multiplicationButton);
        ImageButton divisionButton = findViewById(R.id.divisionButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNumbers();
            }
        });

        additionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        subtractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('×');
            }
        });

        divisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('÷');
            }
        });
    }

    private void generateNumbers() {
        Random random = new Random();

        // Generate two random numbers from 1 to 10
        num1 = random.nextInt(10) + 1; // Generating numbers between 1 and 10
        num2 = random.nextInt(10) + 1;

        // Display the generated numbers
        numberTextView.setText("Number 1: " + num1);
        numberTextView2.setText("Number 2: " + num2);
    }

    private void calculate(char operator) {
        double result = 0;

        // Perform the chosen operation
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '×':
                result = num1 * num2;
                break;
            case '÷':
                // Check if num2 is 0 to avoid division by zero
                if (num2 != 0) {
                    result = (double) num1 / num2;
                } else {
                    // Display a warning message if num2 is 0
                    Toast.makeText(MainActivity.this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return; // Exit the method without further calculation
                }
                break;
        }

        // Display the result
        resultTextView.setText("Result: " + result);
    }
}
