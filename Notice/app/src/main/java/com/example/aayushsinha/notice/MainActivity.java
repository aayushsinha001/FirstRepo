package com.example.aayushsinha.notice;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton ib;
    NotificationCompat.Builder notification;
    private static final int uniqueID=45612;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib=(ImageButton)findViewById(R.id.id_imagebtn);

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        notification.setSmallIcon(R.drawable.bg1);
        notification.setTicker("Hey You got a new Notice");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Notice Board Department");
        notification.setContentText("Check out the notice");

        Intent intent = new Intent(this, DisplayLast.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());
    }

    public void CheckBoard(View v){

    Intent i = new Intent(getApplicationContext(),MyWebView.class);
        startActivity(i);
    }

    public void RegisterLoginPage(View v){
        Intent i = new Intent(this,RegistrationLogin.class);
        startActivity(i);
    }


    public void Notifyme(View v){
        notification.setSmallIcon(R.drawable.bg1);
        notification.setTicker("Hey You got a new Notice");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Notice Board Department");
        notification.setContentText("Check out the notice");

        Intent intent = new Intent(this, DisplayLast.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID,notification.build());

    }

}
