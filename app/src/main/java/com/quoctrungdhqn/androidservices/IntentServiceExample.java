package com.quoctrungdhqn.androidservices;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by NGUYEN Quoc Trung from https://quoctrungdhqn.com on 27/02/2018.
 */

public class IntentServiceExample extends IntentService {

    public IntentServiceExample(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
