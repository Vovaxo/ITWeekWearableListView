package com.epam.wearableapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyActivity extends Activity implements WearableListView.ClickListener {
    public static String[] PLANETS = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
    public static String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        WearableListView listView = (WearableListView) findViewById(R.id.list);
        listView.setAdapter(new Adapter(this));
        listView.setClickListener(this);
    }


    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_POSITION, viewHolder.getPosition());
        startActivity(intent);
    }

    @Override
    public void onTopEmptyRegionClick() {

    }

    private class Adapter extends WearableListView.Adapter {
        private final LayoutInflater mInflater;

        private Adapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new WearableListView.ViewHolder(
                    mInflater.inflate(R.layout.notif_preset_list_item, null));
        }

        @Override
        public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {
            TextView view = (TextView) holder.itemView.findViewById(R.id.name);
            view.setText(PLANETS[position]);
            holder.itemView.setTag(position);
        }

        @Override
        public int getItemCount() {
            return PLANETS.length;
        }
    }
}
