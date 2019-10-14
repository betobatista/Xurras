package com.betobatista.xurras.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.betobatista.xurras.R;

public class MainActivity extends AppCompatActivity {

    // Botões //
    private LinearLayout llBtnEvent;
    private LinearLayout llBtnFriend;
    private LinearLayout llBtnCash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        createComponets();
    }

    private void createComponets() {
        llBtnEvent = findViewById(R.id.llBtnEvent);
        llBtnFriend = findViewById(R.id.llBtnFriend);
        llBtnCash = findViewById(R.id.llBtnCash);

        llBtnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click //
            }
        });

        llBtnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FriendActivity.class);
                startActivity(intent);
            }
        });

        llBtnCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Click //
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
