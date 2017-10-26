package com.rowland.cheffaue.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Rowland on 10/25/2017.
 */

public class ScreenUtils {

    public static int calculateNoOfColumns(Context context, boolean isTwoPane) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        // Have a fraction of screen for two-pane
        if (isTwoPane) {
            dpWidth = displayMetrics.widthPixels * 1 / 2f / displayMetrics.density;
        }
        int scalingFactor = 200;
        int noOfColumns = (int) (dpWidth / scalingFactor);
        return noOfColumns;
    }
}
