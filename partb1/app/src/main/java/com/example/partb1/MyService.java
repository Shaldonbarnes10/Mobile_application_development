package com.example.partb1;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class MyService extends Service {
    MediaPlayer music;
    @Override
    public void onCreate() {
        super.onCreate();
        music = MediaPlayer.create(this,R.raw.a);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (music!=null && !music.isPlaying()){
            music.start();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (music!=null){
            if (music.isPlaying()){
                music.stop();
            }
            music.release();
            music = null;
        }
        super.onDestroy();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
