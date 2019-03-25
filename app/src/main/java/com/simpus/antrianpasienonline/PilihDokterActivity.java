package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PilihDokterActivity extends AppCompatActivity {
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_dokter);

        btn_next =(Button)findViewById(R.id.btn_next );

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intentantrian = new Intent(PilihDokterActivity.this, KartuAntrianActivity.class);
                startActivity(Intentantrian);
            }
        });
    }
}
