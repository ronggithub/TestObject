package com.baidu.searchbox;

import android.util.Log;

public class Utility {

    public static int number;

    public static int setNumber (int num) {
        Log.e("", "");
        number = num;
        return number;
    }

    public static int getNumber() {
        return number;
    }

    public static void showLog(String name) {

    }
}
