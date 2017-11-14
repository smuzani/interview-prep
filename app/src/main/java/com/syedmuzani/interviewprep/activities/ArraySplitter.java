package com.syedmuzani.interviewprep.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.syedmuzani.interviewprep.R;

import java.util.Arrays;

/**
 * Split an array in the middle where the left side has X and the right side has !X, and both
 * have to be equal amounts
 */
public class ArraySplitter extends AppCompatActivity {

    TextView question;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);
        question = findViewById(R.id.tv_text);
        answer = findViewById(R.id.tv_text2);
        myCode();
    }

    private void myCode() {
        int[] array = initArray();
        int x = 8;

        

        display(Arrays.toString(array), "none");
    }

    private int[] initArray() {
        // if x = 8, ans is 2
        // if x = 6, ans is 3
        // if x = 11, ans is 4
        int[] array = new int[5];
        array[0] = 8;
        array[1] = 8;
        array[2] = 6;
        array[3] = 1;
        array[4] = 3;
        return array;
    }

    private void display(String question, String answer) {
        this.question.setText(question);
        this.answer.setText(answer);
    }
}
