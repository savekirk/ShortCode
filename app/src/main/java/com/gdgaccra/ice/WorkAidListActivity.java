package com.gdgaccra.ice;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by kenny on 5/19/16.
 */
public class WorkAidListActivity extends ListActivity {

    //Data source for the list view
    static final String[] PENS = new String[]{
            "This is just an alpha version of the app, ",
            "For test purposes",
            "Will be implemented soon",
            "Coming soon",
            "Be patient",
            "Sorry for the incovinience",
            "Beta Version on its way",
            "And is gonna be dope",
            "Version control not yet implemented",
            "You may call it version -0.1",
            "Thanks for reading the aforementioned jargons"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_work_aid);

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, PENS));
    }
}