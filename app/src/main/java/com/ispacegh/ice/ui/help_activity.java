package com.ispacegh.ice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ispacegh.ice.R;

/**
 * Created by kenny on 5/20/16.
 */
public class help_activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


    }

    /**
     * Called when the user touches the button
     */
    public void GoBack(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
