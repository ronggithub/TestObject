package com.baidu.searchbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Process;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.searchbox.view.AppListFragment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends Activity implements View.OnClickListener {

    private static String TAG ="MainActivity";
    private Button button, apptargetbt;

    private TextView textChannel;

    private boolean DEBUG = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textChannel = findViewById(R.id.channel);
        textChannel.setText("OPPO channel:" + getOPPOChannel("com.baidu.searchbox.channel"));

        button = findViewById(R.id.main_button);
        apptargetbt = findViewById(R.id.apptargetbt);
        button.setOnClickListener(this);
        apptargetbt.setOnClickListener(this);
    }

    /**
     * 获取OPPO预置目录下渠道号，优先读取data目录，如读取不到再读取system目录
     * @param fileName 文件名
     * @return OPPO渠道号
     */
    public String getOPPOChannel(String fileName) {
        String channel = "";
        String oppoDataPath = "/data/etc/appchannel/" + fileName;
        String oppoSystemPath = "/system/etc/appchannel/" + fileName;
        File file = new File(oppoDataPath);
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            if (file.exists() && file.canRead()) {
                inputStream = new FileInputStream(file);
                reader = new BufferedReader(new InputStreamReader(inputStream));
                channel = reader.readLine();
                if (DEBUG) {
                    android.util.Log.d(TAG, "OPPO read data channel success & channel is : " + channel);
                }
            } else {
                file = new File(oppoSystemPath);
                if (file.exists() && file.canRead()) {
                    inputStream = new FileInputStream(file);
                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    channel = reader.readLine();
                    if (DEBUG) {
                        android.util.Log.d(TAG, "OPPO read system channel success & channel is : " + channel);
                    }
                }
            }
        } catch (IOException e) {
            if (DEBUG) {
                android.util.Log.d(TAG, "OPPO read channel error");
            }
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null && reader != null) {
                    inputStream.close();
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return channel;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.main_button:
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.apptargetbt:
                Intent appIntent = new Intent(MainActivity.this, AppTargetActivity.class);

                startActivity(appIntent);
                break;

        }
    }
}
