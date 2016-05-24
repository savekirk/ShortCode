package com.ispacegh.ice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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

        // specify an adapter
        List<ItemObject> rowListItem = getAllItemList();
        mAdapter = new CardViewDataAdapter(MainActivity.this, rowListItem);
        mRecyclerView.setAdapter(mAdapter);

        // Open Permission Dialog @Runtime using below code
//        ActivityCompat.requestPermissions(MainActivity.this,
//                new String[]{Manifest.permission.CALL_PHONE},
//                1);

        //Floating Action Button Declaration
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add Yoour Own Service Card 'Coming soon' ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


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
        if (id == R.id.action_help) {
            Intent intent = new Intent(this, help_activity.class);
            startActivity(intent);
            finish();
            return true;
        } else if (id == R.id.action_about) {
            Intent intent = new Intent(this, about_activity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Handles the references to items displayed on each cards
    private List<ItemObject> getAllItemList() {

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("Fire", R.drawable.fire));
        allItems.add(new ItemObject("Ambulance", R.drawable.ambulance));
        allItems.add(new ItemObject("Police", R.drawable.police));
        allItems.add(new ItemObject("ERT", R.drawable.ert));
        allItems.add(new ItemObject("Safety Tips", R.drawable.safetytips));
        allItems.add(new ItemObject("First Aid", R.drawable.firstaid));
        return allItems;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            /*HERE PERMISSION IS ALLOWED.
            *
            * YOU SHOULD CODE HERE*/

                } else {

                    Toast.makeText(MainActivity.this, "Permission deny to CALL", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}


