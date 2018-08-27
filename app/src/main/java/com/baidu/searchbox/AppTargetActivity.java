package com.baidu.searchbox;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.baidu.searchbox.view.AppListFragment;

public class AppTargetActivity extends AppFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new AppListFragment();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
