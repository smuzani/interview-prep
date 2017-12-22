package com.syedmuzani.interviewprep.activities.concepts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.syedmuzani.interviewprep.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        int x = 7;
        int ans = binarySearch(array, x);

//        String txt = "Count of " + x + " is " + countNInArray(array, x);
        String txt = "Equilibrium of " + x + " is at " + ans;
        display(Arrays.toString(array), txt);
    }

    private int countNInArray(int[] array, int N) {
        List<Integer> list = new ArrayList<>();

        for (int i : array) {
            list.add(i);
        }
        return Collections.frequency(list, N);
    }

    private int countNotNInArray(int[] array, int N) {
        List<Integer> list = new ArrayList<>();

        for (int i : array) {
            list.add(i);
        }
        return list.size() - Collections.frequency(list, N);
    }

    private int[] initArray() {
        // if x = 1, ans is -1
        // if x = 2, ans is 5
        // if x = 3, ans is 5
        // if x = 4, ans is 6
        // if x = 5, ans is 3
        // if x = 6, ans is 5
        // if x = 7, ans is 6
        int[] array = new int[7];
        array[0] = 2;
        array[1] = 5;
        array[2] = 5;
        array[3] = 3;
        array[4] = 5;
        array[5] = 1;
        array[6] = 6;
        return array;
    }

    private void display(String question, String answer) {
        this.question.setText(question);
        this.answer.setText(answer);
    }

    int binarySearch(int[] array, int x) {
        int low = 0;
        int high = array.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            Log.v("AAA", "low: " + low);
            Log.v("AAA", "mid: " + mid);
            Log.v("AAA", "high: " + high);
            int[] leftArr = Arrays.copyOfRange(array, 0, mid);
            int[] rightArr = Arrays.copyOfRange(array, mid+1, array.length);
            Log.v("AAA", "leftArr: " + Arrays.toString(leftArr));
            Log.v("AAA", "rightArr: " + Arrays.toString(rightArr));
            int leftCount = countNInArray(leftArr, x);
            int rightCount = countNotNInArray(rightArr, x);
            Log.v("AAA", "Left count: " + leftCount);
            Log.v("AAA", "Right count: " + rightCount);


            if (leftCount == rightCount) {
                return mid;
            }

            if (leftCount < rightCount) {
                low = mid + 1;
            }

            if (leftCount > rightCount) {
                high = mid - 1;
            }
        }

        return -1;
    }

}
