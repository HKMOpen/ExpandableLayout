package com.github.aakira.expandablelayout;

import android.animation.TimeInterpolator;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Utils {

    public static final int ACCELERATE_DECELERATE_INTERPOLATOR = 0;
    public static final int ACCELERATE_INTERPOLATOR = 1;
    public static final int ANTICIPATE_INTERPOLATOR = 2;
    public static final int ANTICIPATE_OVERSHOOT_INTERPOLATOR = 3;
    public static final int BOUNCE_INTERPOLATOR = 4;
    public static final int DECELERATE_INTERPOLATOR = 5;
    public static final int FAST_OUT_LINEAR_IN_INTERPOLATOR = 6;
    public static final int FAST_OUT_SLOW_IN_INTERPOLATOR = 7;
    public static final int LINEAR_INTERPOLATOR = 8;
    public static final int LINEAR_OUT_SLOW_IN_INTERPOLATOR = 9;
    public static final int OVERSHOOT_INTERPOLATOR = 10;

    /**
     * Creates interpolator.
     *
     * @param interpolatorType
     * @return
     */
    public static TimeInterpolator createInterpolator(@IntRange(from = 0, to = 10) final int interpolatorType) {
        switch (interpolatorType) {
            case ACCELERATE_DECELERATE_INTERPOLATOR:
                return new AccelerateDecelerateInterpolator();
            case ACCELERATE_INTERPOLATOR:
                return new AccelerateInterpolator();
            case ANTICIPATE_INTERPOLATOR:
                return new AnticipateInterpolator();
            case ANTICIPATE_OVERSHOOT_INTERPOLATOR:
                return new AnticipateOvershootInterpolator();
            case BOUNCE_INTERPOLATOR:
                return new BounceInterpolator();
            case DECELERATE_INTERPOLATOR:
                return new DecelerateInterpolator();
            case FAST_OUT_LINEAR_IN_INTERPOLATOR:
                return new FastOutLinearInInterpolator();
            case FAST_OUT_SLOW_IN_INTERPOLATOR:
                return new FastOutSlowInInterpolator();
            case LINEAR_INTERPOLATOR:
                return new LinearInterpolator();
            case LINEAR_OUT_SLOW_IN_INTERPOLATOR:
                return new LinearOutSlowInInterpolator();
            case OVERSHOOT_INTERPOLATOR:
                return new OvershootInterpolator();
            default:
                return new LinearInterpolator();
        }
    }


    public final static void AppendItemToExpandableLaypout(LinearLayout container, ExpandableRelativeLayout layout_component_expandable_layout, final @LayoutRes int layout_id) {
        View a = LayoutInflater.from(container.getContext()).inflate(layout_id, container, false);
        container.addView(a);
        layout_component_expandable_layout.initLayout();
        layout_component_expandable_layout.setExpanded(false);
    }

    public final static void ButtonControlExpandableLayout(ExpandableLayout layout_component_expandable_layout, final ImageView targetArrowImage, @DrawableRes final int close, @DrawableRes final int open) {
        layout_component_expandable_layout.setListener(new ExpandableLayoutListener() {
            @Override
            public void onAnimationStart() {

            }

            @Override
            public void onAnimationEnd() {

            }

            @Override
            public void onPreOpen() {
                targetArrowImage.setImageDrawable(ContextCompat.getDrawable(targetArrowImage.getContext(), close));
            }

            @Override
            public void onPreClose() {

            }

            @Override
            public void onOpened() {

            }

            @Override
            public void onClosed() {
                targetArrowImage.setImageDrawable(ContextCompat.getDrawable(targetArrowImage.getContext(), open));
            }
        });
    }

}