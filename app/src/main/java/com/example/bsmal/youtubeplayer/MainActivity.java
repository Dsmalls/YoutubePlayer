package com.example.bsmal.youtubeplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSingle = (Button) findViewById(R.id.btnPlaySingle);
        Button btnStandalone = (Button) findViewById(R.id.btnStandalone);
        btnSingle.setOnClickListener(this);
        btnStandalone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null; // here im creating my own intents

        switch(v.getId()) {
            case R.id.btnPlaySingle:
                intent = new Intent(this, YoutubeActivity.class); // this will launch my youtube activity
                break;

            case R.id.btnStandalone:
                intent = new Intent(this, StandaloneActivity.class); // this will launch my standalone activity
                break;

            default:
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
