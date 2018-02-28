package com.quoctrungdhqn.androidservices.unboundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.quoctrungdhqn.androidservices.R;

/**
 * Created by NGUYEN Quoc Trung from https://quoctrungdhqn.com on 27/02/2018.
 */

public class UnBoundServiceExample extends Service {

    MediaPlayer mMediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mMediaPlayer = MediaPlayer.create(this, R.raw.see_you_again);

    }

    // Đối với UnBound Service thì hàm này chúng ta không làm gì cả
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mMediaPlayer.start();
        return START_NOT_STICKY; // Service sẽ không chạy lại khi bị hủy bởi hệ thống hoặc người dùng
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMediaPlayer.release();
    }
}
