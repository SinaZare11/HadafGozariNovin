package com.example.ir.xtools.hadaf.hadafgozarinovin;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.TimePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3, editText4, editText5;
    private static final String CHANNELE_ID="picture notif";
    int notification=1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.name);
        editText2 = findViewById(R.id.rep);
        editText3 = findViewById(R.id.date);
        editText4 = findViewById(R.id.hour);
        editText5 = findViewById(R.id.notif);
        editText5.setOnClickListener(v -> {
            notification();
            NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNELE_ID);
            builder.setContentTitle("اسم تایتل");
            builder.setContentText("زمان");
            builder.setSmallIcon(R.drawable.ic_launcher_background);
            builder.setPriority(NotificationCompat.PRIORITY_LOW);

            NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(getApplicationContext());
            notificationManagerCompat.notify(notification,builder.build());

        });


        editText4.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, (view, hourOfDay, minute) -> {
                String ApPm;
                if (hourOfDay >= 12) {
                    ApPm = "pm";
                } else ApPm = "AM";
                editText4.setText(hourOfDay, TextView.BufferType.valueOf(minute + ApPm));
            }, hour, min, false);
            timePickerDialog.show();

        });
        editText2.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, editText4);
            popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(item -> true);
            popupMenu.show();
        });

        editText3.setOnClickListener(v -> {
            final Calendar c = Calendar.getInstance();
            int Year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, (view, year, month1, dayOfMonth) -> editText3.setText(dayOfMonth + month1 + 1 + year), day, month, Year);
            datePickerDialog.show();

        });

        }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void notification() {

        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNELE_ID, "Picture notif", importance);
        channel.setDescription("شامل عکس");
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
    }
}