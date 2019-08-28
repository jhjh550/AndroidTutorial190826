package com.fieldbear.androidtutorial190826.T17_Notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fieldbear.androidtutorial190826.R;

public class T17_NotificationActivity extends AppCompatActivity {

    private NotificationManager mNotificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t17__notification);

        mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            createChannel();
        }

        Button button = findViewById(R.id.btnStart);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
    }


    private static final String CHANNEL_ID = "CHANNEL_ID";
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannel(){

        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID, "Notify demo",
                NotificationManager.IMPORTANCE_DEFAULT);

        channel.enableLights(true);
        channel.setLightColor(Color.BLUE);
        mNotificationManager.createNotificationChannel(channel);
    }

    private void sendNotification(){

        Intent intent = new Intent(this,
                T17_ResultActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(
               this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Notification Example")
                .setContentText("This is Notification.")
                .setSmallIcon(R.drawable.ic_thunder)
                .setChannelId(CHANNEL_ID)
                .setAutoCancel(true)
                .setContentIntent(pIntent)
                .build();

        mNotificationManager.notify(100, notification);
    }
}
