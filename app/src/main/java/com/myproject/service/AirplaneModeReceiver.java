package com.myproject.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    public static final String TAG = "AirplaneModeReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
     if(intent.getAction() !=null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
       boolean isAirplaneModeOn = intent.getBooleanExtra("state",false);
          String msg = isAirplaneModeOn ? "Airplane Mode On" : "Airplane Mode Off";
         Toast.makeText(context,"Airplane Mode Changed",Toast.LENGTH_SHORT).show();

         Log.d(TAG,"Airplane Mode Changed"+msg);
     }
    }
}
