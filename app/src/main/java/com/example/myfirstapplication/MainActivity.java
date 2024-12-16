package com.example.myfirstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int num1 = 0;
    int num2 = 0;
    String ch = "";
    TextView result;
    int res = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        result = findViewById(R.id.resultView);
        result.setText("");
    }

    public void numFunc(View view) {

        Button button = (Button) view;
        String buttonText = button.getText().toString();
        result.append(buttonText);
        if (ch.isEmpty()) {
            num1 = num1 * 10 + Integer.parseInt(buttonText);
        } else {
            num2 = num2 * 10 + Integer.parseInt(buttonText);
        }
    }

    public void operatorFunc(View view) {
        Button button = (Button) view;
        ch = button.getText().toString();
        result.append(ch);
    }

    public void equalOp(View view) {
        if (ch.equals("+")) {
            res = num1 + num2;
        } else if (ch.equals("-")) {
            res = num1 - num2;
        } else if (ch.equals("*")) {
            res = num1 * num2;
        } else if (ch.equals("/")) {
            if (num2 != 0) {
                res = num1 / num2;
            } else {
                result.setText("Can not devide by zero");
            }
        }
        result.append("=" +res);
    }
    public void acFunc(View view){
        res = 0;
        num1 = 0;
        num2 = 0;
        ch = "";
        result.setText("");
    }
}

