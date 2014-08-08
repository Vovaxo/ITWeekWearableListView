package com.epam.wearableapp;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.wearable.view.CrossfadeDrawable;
import android.support.wearable.view.WatchViewStub;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends Activity {
    private int position;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        position = getIntent().getIntExtra(MyActivity.EXTRA_POSITION, 0);
        switch (position) {
            case 0:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_mercury));
                break;
            case 1:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_venus));
                break;
            case 2:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_earth));
                break;
            case 3:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_mars));
                break;
            case 4:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_jupiter));
                break;
            case 5:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_saturn));
                break;
            case 6:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_uranus));
                break;
            case 7:
                stub.setBackground(getResources().getDrawable(R.drawable.ic_neptune));
                break;
        }


        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                mTextView = (TextView) stub.findViewById(R.id.text);
                mTextView.setText(MyActivity.PLANETS[position]);
            }
        });
    }
}
