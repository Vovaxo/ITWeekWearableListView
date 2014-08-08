package com.epam.wearableapp;

import android.animation.ObjectAnimator;
import android.support.wearable.view.CrossfadeDrawable;

public class FadeAnimation extends CrossfadeDrawable {

    public void animateFade() {
        ObjectAnimator.ofFloat(this, "progress", 1).setDuration(1000).start();
    }

}
