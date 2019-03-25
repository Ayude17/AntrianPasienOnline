package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PilihTanggalActivity extends AppCompatActivity {
    Button btn_lanjut1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_tanggal);

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
