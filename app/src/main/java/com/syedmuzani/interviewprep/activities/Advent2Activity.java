package com.syedmuzani.interviewprep.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.syedmuzani.interviewprep.R;

public class Advent2Activity extends AppCompatActivity {

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
        String q = "525\t1263\t146\t954\t188\t232\t1019\t918\t268\t172\t1196\t1091\t1128\t234\t650\t420";
//        String qq = "4011\t4316\t1755\t4992\t228\t240\t3333\t208\t247\t3319\t4555\t717\t1483\t4608\t1387\t3542";
//        String qqq = "2 4 6 8";

        String[] strArr = q.split("\t");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        int high = 0, low = 9;
        for (int i : arr) {
            if (high < i) {
                high = i;
            }

            if (low > i)
                low = i;

            if (high == 9 && low == 0)
                break;
        }

        int diff = high - low;
        Log.v("aaa", "high: " + high + " low: " + low);

        String ans = String.valueOf(diff);
        display(q, ans);
    }

    private void display(String question, String answer) {
        this.question.setText(question);
        this.answer.setText(answer);
    }
}
