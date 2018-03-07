package com.quoctrungdhqn.androidservices.boundservice;

import android.app.ListActivity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.quoctrungdhqn.androidservices.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NGUYEN Quoc Trung from https://quoctrungdhqn.com on 07/03/2018.
 */

public class BoundServiceActivity extends ListActivity implements ServiceConnection {

    private BoundServiceExample mService;
    private List<String> wordList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
        setupApdater();
        initHandle();
    }

    private void setupApdater() {
        wordList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, wordList);
        setListAdapter(adapter);
    }

    private void initHandle() {
        findViewById(R.id.btn_update_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mService != null) {
                    wordList.clear();
                    wordList.addAll(mService.getWordList());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        findViewById(R.id.btn_trigger_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent service = new Intent(getApplicationContext(), BoundServiceExample.class);
                getApplicationContext().startService(service);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, BoundServiceExample.class);
        bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unbindService(this);
    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BoundServiceExample.MyBinder myBinder = (BoundServiceExample.MyBinder) iBinder;
        mService = myBinder.getService();
        Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        mService = null;
    }
}
