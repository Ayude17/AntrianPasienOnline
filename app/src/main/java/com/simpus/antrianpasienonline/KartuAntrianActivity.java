package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KartuAntrianActivity extends AppCompatActivity {
    Button btn_detail_antrian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kartu_antrian);

        //menginisiasikan button
        btn_detail_antrian= (Button) findViewById(R.id.btn_detail_antrian);

        btn_detail_antrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intentpoli = new Intent(KartuAntrianActivity.this, DetailKartuAntrianActivity.class);
                startActivity(Intentpoli);
            }
        });


    }
}
