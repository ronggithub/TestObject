package com.baidu.searchbox.view;

import android.support.v4.app.ListFragment;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.searchbox.data.AppInfo;

import java.util.ArrayList;
import java.util.List;

public class AppListFragment extends ListFragment {

    private ArrayList<AppInfo> appList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getApplist();
        AppAdapter appAdapter = new AppAdapter(this.getActivity(), appList);
        setListAdapter(appAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return super.onCreateView(inflater, container, savedInstanceState);
    }


    /**
     * 获取APP List Info
     *
     * */
    private List<AppInfo> getApplist () {

        appList = new ArrayList<AppInfo>();
        PackageManager pm = this.getActivity().getPackageManager();

        List<PackageInfo> packages = pm.getInstalledPackages(0);

        for (PackageInfo packageInfo : packages) {
            // 判断系统/非系统应用
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0)	// 非系统应用
            {
                AppInfo info = new AppInfo();
                info.appName = packageInfo.applicationInfo.loadLabel(pm)
                        .toString();
                info.pkgName = packageInfo.packageName;
                info.appIcon = packageInfo.applicationInfo.loadIcon(pm);
                info.targetSdkVersion = packageInfo.applicationInfo.targetSdkVersion;
//                packageInfo.applicationInfo.storageUuid;
                // 获取该应用安装包的Intent，用于启动该应用
                info.appIntent = pm.getLaunchIntentForPackage(packageInfo.packageName);
                appList.add(info);
            } else {
                // 系统应用　　　　　　　　
            }
        }
        return appList;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
