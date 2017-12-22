package com.syedmuzani.interviewprep.activities.concepts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.syedmuzani.interviewprep.R;

import java.util.Arrays;
import java.util.Hashtable;

public class Primes extends AppCompatActivity {

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
        long key = 1000;
        Hashtable<Integer, Boolean> cps = getAllCircularPrimes((int) key);
        display(String.valueOf(key), String.valueOf(cps.toString()));
    }

    private void display(String question, String answer) {
        this.question.setText(question);
        this.answer.setText(answer);
    }

    private boolean checkPrimeNumber(long n) {
        if (n < 2) {
            return false;
        } else {
            long sqrt = (int) Math.sqrt(n);
            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean[] sieve(int max) {
        boolean[] results = new boolean[max + 1];
        Arrays.fill(results, true);
        results[0] = false;
        results[1] = false;

        int prime = 2;
        int sqrt = (int) Math.sqrt(max);
        while (prime <= sqrt) {
            if (results[prime]) {
                int notPrime = 0, i = 2;
                while (notPrime <= max) {
                    notPrime = i * prime;
                    if (notPrime > max) {
                        break;
                    }
                    results[notPrime] = false;
                    i++;
                }
            }
            prime++;
        }

        return results;
    }

    private int[] cyclicNumbers(int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int[] results = new int[len];
        if (len < 2) {
            if (len == 1) {
                results[0] = n;
            }
            return results;
        }

        results[0] = Integer.parseInt(s);
        for (int rotations = 1; rotations < len; rotations++) {
            s = cycle(s);
            results[rotations] = Integer.parseInt(s);
        }

        return results;
    }

    private String cycle(String s){
        int len = s.length();
        String cycled = "" + s.charAt(len - 1);
        cycled += s.substring(0, len-1);
        return cycled;
    }

    private Hashtable<Integer, Boolean> getAllCircularPrimes(int max) {
        Hashtable<Integer, Boolean> ans = new Hashtable<>();
        boolean[] sieves = sieve((int) max + 1);
        Log.d("primes", Arrays.toString(sieves));
        for (int i = 2; i < max; i++) {
            int[] cyclics = cyclicNumbers(i);
            boolean isCircularPrime = true;
            for (int value : cyclics) {
                Log.v("primes", "i: " + i + ", cyclics: " + Arrays.toString(cyclics));
                Log.v("primes", i + " is prime: " + sieves[i]);
                if (!sieves[value]) {
                    isCircularPrime = false;
                    break;
                }
            }
            if (isCircularPrime) {
                Log.v("primes", "is circular prime: " + i);
                ans.put(i, true);
            }
        }
        return ans;
    }
}
