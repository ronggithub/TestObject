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
        textChannel.setText("");

        button = findViewById(R.id.main_button);
        apptargetbt = findViewById(R.id.apptargetbt);
        button.setOnClickListener(this);
        apptargetbt.setOnClickListener(this);
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
