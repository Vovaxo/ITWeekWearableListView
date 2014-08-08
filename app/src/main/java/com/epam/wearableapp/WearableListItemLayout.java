package com.epam.wearableapp;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WearableListItemLayout extends LinearLayout implements WearableListView.Item {

    private final float mFadedTextAlpha;
    private float mScale;
    private TextView mName;


    public WearableListItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        mFadedTextAlpha = getResources().getInteger(R.integer.action_text_faded_alpha) / 100f;
    }

    public WearableListItemLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mFadedTextAlpha = getResources().getInteger(R.integer.action_text_faded_alpha) / 100f;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mName = (TextView) findViewById(R.id.name);
    }

    @Override
    public float getProximityMinValue() {
        return 1f;
    }

    @Override
    public float getProximityMaxValue() {
        return 1.6f;
    }

    @Override
    public float getCurrentProximityValue() {
        return mScale;
    }

    @Override
    public void setScalingAnimatorValue(float scale) {
        mScale = scale;
        mName.setPivotX(0);
        mName.setScaleX(scale);
        mName.setPivotY(mName.getHeight() / 2);
        mName.setScaleY(scale);
    }

    @Override
    public void onScaleUpStart() {
        mName.setAlpha(1f);
    }

    @Override
    public void onScaleDownStart() {
        mName.setAlpha(mFadedTextAlpha);
    }

}
