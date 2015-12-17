package com.terryyamg.lollipopnotificationtest;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btNotification = (Button) findViewById(R.id.btNotification);

        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Detail.class); //點選後動作
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, (int) System.currentTimeMillis(), intent, 0);
                // addAction(int icon, CharSequence title, PendingIntent intent) Deprecated 的解決方法
                NotificationCompat.Action detailAction =
                        new NotificationCompat.Action.Builder(R.mipmap.ic_launcher, "Detail", pIntent).build();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentTitle("標題");
                builder.setContentText("內容");
                builder.setOngoing(false); //固定
//              builder.setFullScreenIntent(pIntent,true);//一直顯示在最上層 優先於setPriority
                builder.setPriority(Notification.PRIORITY_DEFAULT); //通知的位置 - Android 5.0 PRIORITY_MIN在底線以下
                builder.setVisibility(NotificationCompat.VISIBILITY_PRIVATE); //顯示訊息-VISIBILITY_PUBLIC 公開,VISIBILITY_PRIVATE私密
                builder.addAction(detailAction); //加入下方按鈕

                NotificationManager notificationManager =
                        (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.build());

            }
        });

    }
}
