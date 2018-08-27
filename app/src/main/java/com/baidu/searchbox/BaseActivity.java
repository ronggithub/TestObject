package com.baidu.searchbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.util.Log;

public class BaseActivity extends Activity {

    private String TAG = "BaseActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e(TAG, "onCreate ; ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart ; "+ Utility.getNumber());

        Log.e(TAG, Process.myPid() +": " +
        Process.myUid()+": "+
        Process.myTid());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState ; ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume ; ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "onNewIntent ; ");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause ; ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState ; ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop ; ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy ; ");

    }
}
