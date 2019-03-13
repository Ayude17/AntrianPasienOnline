package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DaftarActivity extends AppCompatActivity {
    Button btnDaftar, btnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        btnMasuk = (Button) findViewById(R.id.btn_masuk);

        btnMasuk .setOnClickListener(new View.OnClickListener() {
            //onClick untuk button Daftar
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaftarActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
