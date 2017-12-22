package com.syedmuzani.interviewprep.activities.aoc;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.syedmuzani.interviewprep.R;

import java.util.ArrayList;
import java.util.List;

public class Advent20161Activity extends AppCompatActivity {

    public static final int MAX = 3;

    TextView question;
    TextView answer;
    int orientation = 0;
    int x = 0;
    int y = 0;
    List<Point> coords = new ArrayList<>();
    int xAns = 0;
    int yAns = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tester);
        question = findViewById(R.id.tv_text);
        answer = findViewById(R.id.tv_text2);
        myCode();
    }

    private void myCode() {
        String q = "L2, L5, L5, R5, L2, L4, R1, R1, L4, R2, R1, L1, L4, R1, L4, L4, R5, R3, R1, L1, R1, L5, L1, R5, L4, R2, L5, L3, L3, R3, L3, R4, R4, L2, L5, R1, R2, L2, L1, R3, R4, L193, R3, L5, R45, L1, R4, R79, L5, L5, R5, R1, L4, R3, R3, L4, R185, L5, L3, L1, R5, L2, R1, R3, R2, L3, L4, L2, R2, L3, L2, L2, L3, L5, R3, R4, L5, R1, R2, L2, R4, R3, L4, L3, L1, R3, R2, R1, R1, L3, R4, L5, R2, R1, R3, L3, L2, L2, R2, R1, R2, R3, L3, L3, R4, L4, R4, R4, R4, L3, L1, L2, R5, R2, R2, R2, L4, L3, L4, R4, L5, L4, R2, L4, L4, R4, R1, R5, L2, L4, L5, L3, L2, L4, L4, R3, L3, L4, R1, L2, R3, L2, R1, R2, R5, L4, L2, L1, L3, R2, R3, L2, L1, L5, L2, L1, R4";
//        String q = "R2, R2, R1, R2";
        String[] orders = q.split(", ");

        for (String order : orders) {
            Log.v("order", order);
            String direction = String.valueOf(order.charAt(0));
            int steps = Integer.parseInt(order.substring(1, order.length()));
            turn(direction);
            walk(steps);
        }

        int moves = Math.abs(xAns) + Math.abs(yAns);
        Log.v("coord", "X: " + xAns + ", Y: " + yAns);
        Log.d("hashmap", coords.toString());
        String ans = String.valueOf(moves);
        display(q, ans);
    }

    private void display(String question, String answer) {
        this.question.setText(question);
        this.answer.setText(answer);
    }

    void turn(String direction) {
        if (direction.equals("L")) {
            orientation--;
        }

        if (direction.equals("R")) {
            orientation++;
        }

        if (orientation > MAX) {
            orientation = 0;
        }

        if (orientation < 0) {
            orientation = MAX;
        }
    }

    void walk(int steps) {
        switch (orientation) {
            case 0:
                for (int i = 0; i < steps; i++) {
                    y++;
                    Point coord = new Point(x, y);
                    if (!coords.contains(coord))
                        coords.add(coord);
                    else {
                        if (xAns == 0 && yAns ==0) {
                            xAns = x;
                            yAns = y;
                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < steps; i++) {
                    x++;
                    Point coord = new Point(x, y);
                    if (!coords.contains(coord))
                        coords.add(coord);
                    else {
                        if (xAns == 0 && yAns ==0) {
                            xAns = x;
                            yAns = y;
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < steps; i++) {
                    y--;
                    Point point = new Point(x, y);
                    if (!coords.contains(point))
                        coords.add(point);
                    else {
                        if (xAns == 0 && yAns ==0) {
                            xAns = x;
                            yAns = y;
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < steps; i++) {
                    x--;
                    Point coord = new Point(x, y);
                    if (!coords.contains(coord))
                        coords.add(coord);
                    else {
                        if (xAns == 0 && yAns ==0) {
                            xAns = x;
                            yAns = y;
                        }
                    }
                }
                break;
        }


    }
}
