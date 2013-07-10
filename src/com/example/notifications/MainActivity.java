package com.example.notifications;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	int notificationID=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Button button=(Button) findViewById(R.id.btn_notifi);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				displayNotification();
				
			}

		});
		
	}

	
	protected void displayNotification() {
		Intent i= new Intent(this,NotificationView.class);
		i.putExtra("notificationID",notificationID);
		
		PendingIntent pendingIntent =PendingIntent.getActivity(this, 0, i, 0);
		
		CharSequence from="System Alarm";
		CharSequence message="Meeting with customer at 3pm.";
		NotificationCompat.Builder nb =   new NotificationCompat.Builder(this);
	
		nb.setSmallIcon(R.drawable.ic_launcher);
		nb.setContentTitle(from.toString());
		nb.setContentText(message);
		nb.setAutoCancel(true);
		nb.setContentIntent(pendingIntent);
	

		Notification notification = nb.build();
		notification.vibrate=new long[]{100,250,100,500};
		
		
		NotificationManager notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
		notificationManager.notify(0, notification); 
		
		
		
		
		
		
		/*Intent i= new Intent(this,NotificationView.class);
		i.putExtra("notificationID",notificationID);
		
		PendingIntent pendingIntent =PendingIntent.getActivity(this, 0, i, 0);
		
		NotificationManager nm=(NotificationManager)
				getSystemService(NOTIFICATION_SERVICE);
		
		
		Notification notif=new Notification(
				R.drawable.icon,"Reminder:Meeting Starts in 5 minutes",System.currentTimeMillis());
		
		
		CharSequence from="System Alarm";
		CharSequence message="Meeting with customer at 3pm.";
		notif.setLatestEventInfo(this, from, message, pendingIntent);
		notif.vibrate=new long[]{100,250,100,500};
		nm.notify(notificationID,notif);	*/		
		
	}
	
}
