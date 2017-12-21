package com.syedmuzani.interviewprep.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.syedmuzani.interviewprep.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Advent20172Activity extends AppCompatActivity {

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
        String[] fileLines = splitFileToLines(R.raw.advent_2017_2);
        String q = Arrays.toString(fileLines);

        /* First star

        int diffTotal = 0;
        for (String fileLine : fileLines) {
            String[] nums = fileLine.split("\\s+");
            int[] ns = strArrayToIntArray(nums);
            int high = 0, low = 9;
            for (int n : ns) {
                if (high < n) {
                    high = n;
                }

                if (low > n)
                    low = n;

                if (high == 9 && low == 0)
                    break;
            }
            int diff = high - low;
            diffTotal += diff;
        } */

        int divTotal = 0;
        for (String fileLine : fileLines) {
            String[] nums = fileLine.split("\\s+");
            int[] ns = strArrayToIntArray(nums);
            int a = 999, b = 998, i = 0;
            int len = ns.length;
            for (i = 0; a % b != 0 && i < len; i++) {
                a = ns[i];
                for (int j : ns) {
                    if (j == ns[i]) {
                        continue;
                    }
                    b = j;
                    if (a % b == 0) {
                        break;
                    }
                }
            }

            int results = a / b;
            divTotal += results;
        }

        String ans = String.valueOf(divTotal);
        display(q, ans);
    }

    private void display(String question, String answer) {
        this.question.setText(question);
        this.answer.setText(answer);
    }

    private String[] splitFileToLines(int rawId) {
        List<String> ret = new ArrayList<>();

        try {
            InputStream inputStream = getResources().openRawResource(rawId);

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                while ((receiveString = bufferedReader.readLine()) != null) {
                    ret.add(receiveString);
                }

                inputStream.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("readFromFile", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("readFromFile", "Can not read file: " + e.toString());
        }

        return ret.toArray(new String[0]);
    }

    private int[] strArrayToIntArray(String[] numberStrs) {
        int[] numbers = new int[numberStrs.length];
        for (int i = 0; i < numberStrs.length; i++) {
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }
        return numbers;
    }
}
