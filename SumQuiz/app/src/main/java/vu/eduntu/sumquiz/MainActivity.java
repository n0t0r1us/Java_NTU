package vu.eduntu.sumquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button option1Button, option2Button, option3Button, option4Button;
    private TextView resultTextView;
    private int correctAnswers = 0;
    private int totalQuestions = 0;
    private Button changeQuestionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);
        resultTextView = findViewById(R.id.resultTextView);
        changeQuestionButton = findViewById(R.id.changeQuestionButton);

        // Set up initial question
        showNextQuestion();

        // Set onClickListeners for option buttons
        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option1Button.getText().toString());
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option2Button.getText().toString());
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option3Button.getText().toString());
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(option4Button.getText().toString());
            }
        });
        changeQuestionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNextQuestion();
            }
        });
    }


    private void showNextQuestion() {
        Random random = new Random();

        // Generate two random numbers from 1 to 10
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;

        // Generate random operator
        char operator;
        int operatorIndex = random.nextInt(4);
        switch (operatorIndex) {
            case 0:
                operator = '+';
                break;
            case 1:
                operator = '-';
                break;
            case 2:
                operator = '×';
                break;
            case 3:
                operator = '÷';
                break;
            default:
                operator = '+'; // Default to addition
                break;
        }

        // Calculate correct answer
        int correctAnswer = calculate(num1, num2, operator);

        // Display question
        questionTextView.setText(num1 + " " + operator + " " + num2 + " = ?");

        // Generate options
        int[] options = generateOptions(correctAnswer);

        // Display options
        option1Button.setText(String.valueOf(options[0]));
        option2Button.setText(String.valueOf(options[1]));
        option3Button.setText(String.valueOf(options[2]));
        option4Button.setText(String.valueOf(options[3]));
    }

    private int calculate(int num1, int num2, char operator) {
        int result = 0;
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
                result = num1 / num2;
                break;
        }
        return result;
    }

    private int[] generateOptions(int correctAnswer) {
        Random random = new Random();
        int[] options = new int[4];
        options[random.nextInt(4)] = correctAnswer; // Place correct answer in a random position

        // Generate other options
        for (int i = 0; i < 4; i++) {
            if (options[i] == 0) {
                options[i] = correctAnswer + random.nextInt(10) - 5; // Generate numbers close to correct answer
            }
        }
        return options;
    }

    private void checkAnswer(String selectedOption) {
        int selectedAnswer = Integer.parseInt(selectedOption);
        if (selectedAnswer == calculateAnswer()) {
            // Correct answer
            correctAnswers++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            // Incorrect answer
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }

        totalQuestions++;

        // Update result text
        resultTextView.setText("Result: " + correctAnswers + "/" + totalQuestions);

        // Show next question
        if (totalQuestions < 10) {
            showNextQuestion();
        } else {
            // Quiz finished
            Toast.makeText(this, "Quiz finished!", Toast.LENGTH_SHORT).show();
            // Disable option buttons
            option1Button.setEnabled(false);
            option2Button.setEnabled(false);
            option3Button.setEnabled(false);
            option4Button.setEnabled(false);
        }
    }

    private int calculateAnswer() {
        int num1 = Integer.parseInt(questionTextView.getText().toString().split(" ")[0]);
        char operator = questionTextView.getText().toString().split(" ")[1].charAt(0);
        int num2 = Integer.parseInt(questionTextView.getText().toString().split(" ")[2]);
        return calculate(num1, num2, operator);
    }
}