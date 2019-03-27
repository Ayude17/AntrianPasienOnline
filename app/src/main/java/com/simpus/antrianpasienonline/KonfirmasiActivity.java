package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class KonfirmasiActivity extends AppCompatActivity implements View.OnClickListener  {
    private Button btn_batal,btn_antri;
    TextView PasienView,PoliView,DokterView, RujukanView, TglView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        //inisiasi variable
        btn_batal =(Button)findViewById(R.id.btn_batal );
        btn_antri =(Button)findViewById(R.id.btn_antri );
        PasienView =(TextView)findViewById(R.id.PasienView );
        PoliView =(TextView)findViewById(R.id.PoliView );
        DokterView =(TextView)findViewById(R.id.DokterView );
        RujukanView =(TextView)findViewById(R.id.RujukanView );
        TglView =(TextView)findViewById(R.id.TglView );

        //mendefinisikan onclick listener
        btn_batal.setOnClickListener(this);
        btn_antri.setOnClickListener(this);

    }
    // mendefiniskan ketika button di click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_batal:
                Toast.makeText(this, "antrian dibatalkan", Toast.LENGTH_SHORT).show();
                Intent IntenOut = new Intent(KonfirmasiActivity.this, KartuAntrianActivity.class);
                startActivity(IntenOut);

                finish();
                break;

            case R.id.btn_antri:
//                Intent IntenOut = new Intent(MenuActivity.this, FinishedActivity.class);
//                startActivity(IntenOut);
                Toast.makeText(this, "memulai antri", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
