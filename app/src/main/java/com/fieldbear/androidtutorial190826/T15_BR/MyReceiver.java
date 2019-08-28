package com.fieldbear.androidtutorial190826.T15_BR;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "my receiver: power connected",
                    Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
            int level = intent.getIntExtra("level", 0);
            Toast.makeText(context, "battery: "+level,
                    Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals("adfadsfasdf")){
            Toast.makeText(context, "my receiver: adfadsfasdf",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
