package com.ispacegh.ice.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ispacegh.ice.R;
import com.ispacegh.ice.adapter.SafetyListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SafetyActivity extends Activity {

    private List<ArticleListItem> articles;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_safety);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        articles = new ArrayList<>();
        articles.add(new ArticleListItem("Road Safety", "car accidents & Bike accidents preventions, traffic clashes, road safety rules etc.. ", R.drawable.road));
        articles.add(new ArticleListItem("Home Safety ", "Burns/Fire preventions , Poison, Fire escape plans, family safety plans etc.. ", R.drawable.home));
        articles.add(new ArticleListItem("Work Safety", "Workplace hazards, occupational disease, work accident, injury etc.. ", R.drawable.work));
        articles.add(new ArticleListItem("Air Safety", "flight failures, aircraft accidents, airplane do's & dont's etc..", R.drawable.air));
    }

    private void initializeAdapter() {
        SafetyListAdapter adapter = new SafetyListAdapter(articles);
        rv.setAdapter(adapter);
    }


}