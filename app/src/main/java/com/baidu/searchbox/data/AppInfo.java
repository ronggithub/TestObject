package com.baidu.searchbox.data;

import android.content.Intent;
import android.graphics.drawable.Drawable;

public class AppInfo {

    public String versionName;

    public int targetSdkVersion;

    public String apiVersion;

    public String pkgName;

    public String appName;

    public Drawable appIcon;

    public Intent appIntent;


    @Override
    public String toString() {
        return "AppInfo{" +
                "versionName='" + versionName + '\'' +
                ", targetSdkVersion='" + targetSdkVersion + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                ", pkgName='" + pkgName + '\'' +
                ", appName='" + appName + '\'' +
                ", appIcon=" + appIcon +
                ", appIntent=" + appIntent +
                '}';
    }
}
