package com.myproject.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

public class MyCustomService extends Service {
     MediaPlayer player;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
   public int  onStartCommand(Intent intent,int flags, int startId){
          player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        return START_STICKY;
   }

}