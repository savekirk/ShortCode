package com.ispacegh.ice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a GridLayout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        List<ItemObject> rowListItem = getAllItemList();
        mAdapter = new CardViewDataAdapter(MainActivity.this, rowListItem);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Settings Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;
       /* } else if (id == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Search Clicked",
                    Toast.LENGTH_SHORT).show();
            return true;*/
        }
        return super.onOptionsItemSelected(item);
    }

    //Handles the references to items displayed on each cards
    private List<ItemObject> getAllItemList() {

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Fire", R.drawable.fire));
        allItems.add(new ItemObject("Ambulance", R.drawable.ambulance));
        allItems.add(new ItemObject("Police", R.drawable.police));
        allItems.add(new ItemObject("AntiSquad", R.drawable.police));
        return allItems;
    }


}