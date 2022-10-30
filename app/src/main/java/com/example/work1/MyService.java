package com.example.work1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer mediaPlayer;
    private Mybinder mybinder;
    public MyService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("server","star");
//        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.hetu);
//        mediaPlayer.start();
    }



    @Override
    public void onDestroy() {
        Log.d("server","stop");
        mediaPlayer.stop();
        super.onDestroy();
    }

    class Mybinder extends Binder { //method 播放音乐
        public void play() {
            mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.hetu);
            mediaPlayer.start();
        }};

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mybinder = new Mybinder();
        return mybinder;
    }
}
