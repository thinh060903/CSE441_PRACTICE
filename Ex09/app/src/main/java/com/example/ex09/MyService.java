package com.example.ex09;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    MediaPlayer mymedia;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mymedia = MediaPlayer.create(MyService.this, R.raw.soundhelix_song_1);
        mymedia.setLooping(true); // Cho phép lặp lại liên tục
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mymedia.isPlaying()) {
            mymedia.pause();
        } else {
            mymedia.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mymedia.stop();
    }
}

