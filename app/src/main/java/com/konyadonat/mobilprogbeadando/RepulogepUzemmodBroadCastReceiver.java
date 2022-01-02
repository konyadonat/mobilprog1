package com.konyadonat.mobilprogbeadando;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class RepulogepUzemmodBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (bevanekapcsolva(context.getApplicationContext())){
            Toast.makeText(context,"Repülőgép üzemmód bekapcsolva!",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(context,"Repülőgép üzemmód kikapcsolva!",Toast.LENGTH_LONG).show();
        }
    }



    private static boolean bevanekapcsolva(Context context){
        return Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0) != 0;
    }
}
