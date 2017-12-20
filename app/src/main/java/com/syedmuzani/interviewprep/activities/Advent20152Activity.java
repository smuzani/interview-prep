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

public class Advent20152Activity extends AppCompatActivity {

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
        String[] fileLines = splitFileToLines(R.raw.advent_2015_2);
        /*int totalWrapping = 0;
        for (String fileLine : fileLines) {
            String[] dimens = fileLine.split("x");
            int l = Integer.parseInt(dimens[0]);
            int w = Integer.parseInt(dimens[1]);
            int h = Integer.parseInt(dimens[2]);
            int surface = 2 * l * w + 2 * w * h + 2 * h * l;
            int slack = Math.min(l * w, Math.min(w * h, h * l));
            totalWrapping += surface + slack;
        }*/

        int totalRibbon = 0;
        for (String fileLine : fileLines) {
            String[] dimens = fileLine.split("x");
            int l = Integer.parseInt(dimens[0]);
            int w = Integer.parseInt(dimens[1]);
            int h = Integer.parseInt(dimens[2]);
            int bowSize = l*w*h;
            int parameters = getSmallestPerimeter(l,w,h);
            totalRibbon += bowSize + parameters;
        }

        String q = Arrays.toString(fileLines);
        String ans = String.valueOf(totalRibbon);
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

    int getSmallestPerimeter(int l, int h, int w) {
        int maxDimen = Math.max(l, Math.max(w,h));
        if (maxDimen == l) {
            return getParameter(h,w);
        } else if (maxDimen == h) {
            return getParameter(l,w);
        } else {
            return getParameter(l,h);
        }
    }

    int getParameter(int a, int b) {
        return a*2 + b*2;
    }

}
