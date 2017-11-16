package com.syedmuzani.interviewprep.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.syedmuzani.interviewprep.R;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ArrayTypes extends AppCompatActivity {

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
        // Hash Tables
        Hashtable<String, String> hash = new Hashtable<>();
        hash.put("mee", "ali");
        hash.put("mee", "ali 2");
        hash.put("kek", "ainul");

        String key = "kek";
        String value = hash.get(key);

        // ArrayList
        List<String> list = new ArrayList<>();
        key = "aaa";
        list.add(key);
        value = list.get(0);

        display(key, value);
    }

    private void display(String question, String answer) {
        this.question.setText(question);
        this.answer.setText(answer);
    }
}
