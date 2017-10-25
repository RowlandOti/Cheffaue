package com.rowland.cheffaue.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Rowland on 10/25/2017.
 */

public class ScreenUtils {

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int scalingFactor = 180;
        int noOfColumns = (int) (dpWidth / scalingFactor);
        return noOfColumns;
    }
}
