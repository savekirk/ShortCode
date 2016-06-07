package com.gdgaccra.ice;

/**
 * Created by kenny on 5/19/16.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FirstAidActivity extends Activity {

    private List<ArticleListItem> articles;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firstaid);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        articles = new ArrayList<>();
        articles.add(new ArticleListItem("Road Accidents", "vehicle accidents, bomb blasts, explosions etc..", R.drawable.aidcar));
        articles.add(new ArticleListItem("Home Remedies", "Bone fracture, Burns, cardiac arrest, choking, bleeding etc..", R.drawable.aidhome));
        articles.add(new ArticleListItem("Work Accidents", "muscle cramps, sustained injury, faint etc..", R.drawable.aidwork));
        articles.add(new ArticleListItem("Others", "child birth and other kinds of accidents", R.drawable.aidothers));
    }

    private void initializeAdapter() {
        FirstAidListAdapter adapter = new FirstAidListAdapter(articles);
        rv.setAdapter(adapter);
    }
}