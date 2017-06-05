package com.operr.restaurant.utils;

import android.app.Activity;
import android.net.ConnectivityManager;

/**
 * Created by Daoud Shaheen on 6/5/2017.
 */

public class Utils {
    public static boolean isNetworkConnected(Activity activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(activity.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
