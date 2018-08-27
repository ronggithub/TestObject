package com.baidu.searchbox.view;

import android.appwidget.AppWidgetProviderInfo;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.searchbox.R;
import com.baidu.searchbox.data.AppInfo;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AppAdapter extends BaseAdapter {

    private Context mContxt;

    private ArrayList<AppInfo> mList;

    private LayoutInflater inflater;


    public AppAdapter(Context contxt, ArrayList<AppInfo> list) {
        this.mList = list;
        this.mContxt = contxt;
        this.inflater = LayoutInflater.from(contxt);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.appitem, null);
            viewHolder.appicon = convertView.findViewById(R.id.appicon);
            viewHolder.appname = convertView.findViewById(R.id.appname);
            viewHolder.apptarget = convertView.findViewById(R.id.apptarget);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        AppInfo info = mList.get(position);
        viewHolder.appicon.setImageDrawable(info.appIcon);
        viewHolder.appname.setText(info.appName);
        viewHolder.apptarget.setText("" + info.targetSdkVersion);

        return convertView;
    }

    class ViewHolder {
        ImageView appicon;
        TextView appname;
        TextView apptarget;
    }

}
