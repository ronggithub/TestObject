package com.baidu.searchbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.baidu.searchbox.view.AppListFragment;

public abstract class AppFragmentActivity extends FragmentActivity {

    private String TAG = "appFragmentAc";

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.applistlayout);

        Log.e(TAG, "----oncreate-------");

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.applist);
        if (fragment == null) {
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.applist, fragment)
                    .commit();
        }

    }



}
