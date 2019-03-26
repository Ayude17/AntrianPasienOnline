package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class PilihTanggalActivity extends AppCompatActivity {
    Button btn_lanjut1;
    CalendarView calendarView;
    TextView tanggalView;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_tanggal);

        //inisiasi calendar
        calendarView = (CalendarView) findViewById(R.id.calendarView);
        tanggalView = (TextView) findViewById(R.id.tanggalView);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( @NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                month = month + 1;
                String formattedMonth = "" + month;
                String formattedDayOfMonth = "" + dayOfMonth;
                if(month < 10){

                    formattedMonth = "0" + month;
                }
                if(dayOfMonth < 10){

                    formattedDayOfMonth = "0" + dayOfMonth;
                }

                tanggalView.setText(year + "-" + formattedMonth + "-" +formattedDayOfMonth );
            }
        });

        //menginisiasikan button
        btn_lanjut1= (Button) findViewById(R.id.btn_lanjut1);

        btn_lanjut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intentpoli = new Intent(PilihTanggalActivity.this, PilihPoliActivity.class);
                startActivity(Intentpoli);
            }
        });

    }
}
