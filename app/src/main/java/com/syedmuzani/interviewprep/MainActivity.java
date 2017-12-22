package com.syedmuzani.interviewprep;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.syedmuzani.interviewprep.activities.aoc.Advent20151Activity;
import com.syedmuzani.interviewprep.activities.aoc.Advent20152Activity;
import com.syedmuzani.interviewprep.activities.aoc.Advent20161Activity;
import com.syedmuzani.interviewprep.activities.aoc.Advent20171Activity;
import com.syedmuzani.interviewprep.activities.aoc.Advent20172Activity;
import com.syedmuzani.interviewprep.activities.concepts.ArraySplitter;
import com.syedmuzani.interviewprep.activities.concepts.ArrayTypes;
import com.syedmuzani.interviewprep.activities.concepts.Primes;
import com.syedmuzani.interviewprep.adapters.MainPageListAdapter;
import com.syedmuzani.interviewprep.models.MainMenuLink;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Activity activity = this;
    List<MainMenuLink> links = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView rv = findViewById(R.id.rv);
        initRecyclerView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                linearLayoutManager.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        rv.setAdapter(new MainPageListAdapter(links));
    }

    private void initRecyclerView() {
        links.add(new MainMenuLink("Array Splitter", ArraySplitter.class));
        links.add(new MainMenuLink("Primes", Primes.class));
        links.add(new MainMenuLink("Arrays", ArrayTypes.class));
        links.add(new MainMenuLink("AoC 2015 Day 1", Advent20151Activity.class));
        links.add(new MainMenuLink("AoC 2015 Day 2", Advent20152Activity.class));
        links.add(new MainMenuLink("AoC 2016 Day 1", Advent20161Activity.class));
        links.add(new MainMenuLink("AoC 2017 Day 1", Advent20171Activity.class));
        links.add(new MainMenuLink("AoC 2017 Day 2", Advent20172Activity.class));
    }
}
