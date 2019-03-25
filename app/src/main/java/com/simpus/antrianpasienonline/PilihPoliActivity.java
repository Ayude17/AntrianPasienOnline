package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PilihPoliActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_kembali2,btn_lanjut2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_poli);
        //mendefinisikan variable
        btn_kembali2 =(Button)findViewById(R.id.btn_kembali2 );
        btn_lanjut2 =(Button)findViewById(R.id.btn_lanjut2 );

        //mendefinisikan onclick listener
        btn_kembali2.setOnClickListener(this);
        btn_lanjut2.setOnClickListener(this);

    }

    // mendefiniskan ketika button di click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_kembali2:
                finish();
                break;

            case R.id.btn_lanjut2:
              Intent IntenOut = new Intent(PilihPoliActivity.this, PilihDokterActivity.class);
               startActivity(IntenOut);

                break;

        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
