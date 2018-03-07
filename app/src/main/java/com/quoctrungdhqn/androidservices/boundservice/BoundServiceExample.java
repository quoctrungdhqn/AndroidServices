package com.quoctrungdhqn.androidservices.boundservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by NGUYEN Quoc Trung from https://quoctrungdhqn.com on 05/02/2018.
 */

public class BoundServiceExample extends Service {
    private final IBinder mBinder = new MyBinder();
    private List<String> resultList = new ArrayList<>();
    private int counter = 1;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        addResultValues();
        return mBinder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        addResultValues();
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class MyBinder extends Binder {
        BoundServiceExample getService() {
            return BoundServiceExample.this;
        }
    }

    private void addResultValues() {
        Random random = new Random();
        List<String> input = Arrays.asList("Android", "iOS", "PHP", "JavaScript");
        resultList.add(input.get(random.nextInt(4)) + " " + counter++);
        if (counter == Integer.MAX_VALUE) {
            counter = 0;
        }
    }

    public List<String> getWordList() {
        return resultList;
    }
}
