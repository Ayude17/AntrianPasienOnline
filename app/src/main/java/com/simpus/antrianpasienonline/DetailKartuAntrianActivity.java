package com.simpus.antrianpasienonline;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailKartuAntrianActivity extends AppCompatActivity implements View.OnClickListener  {
    Button btn_batal_antri,btn_tanya_admin;
    TextView NoAntrianView,PasienView,PoliView,DokterView,RujukanView,TglView,waktuView;
    String norm,norujukan,idjadwal,poli,namaDokter,namaPasien,nomorAntrian,waktuAntrian,tanggalAntri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kartu_antrian);
        btn_batal_antri =(Button)findViewById(R.id.btn_batal_antri );
        btn_tanya_admin =(Button)findViewById(R.id.btn_tanya_admin );
        NoAntrianView =(TextView) findViewById(R.id.NoAntrianView );
        PasienView =(TextView) findViewById(R.id.PasienView );
        PoliView =(TextView) findViewById(R.id.PoliView );
        DokterView =(TextView) findViewById(R.id.DokterView );
        RujukanView =(TextView) findViewById(R.id.RujukanView );
        TglView =(TextView) findViewById(R.id.TglView );
        waktuView =(TextView) findViewById(R.id.waktuView );


        //mendefinisikan onclick listener
        btn_batal_antri.setOnClickListener(this);
        btn_tanya_admin.setOnClickListener(this);

        //mengambil intent dari intent sebelumnya
        Bundle extras = getIntent().getExtras();
        idjadwal = extras.getString("id_jadwal");
        poli = extras.getString("poli");
        namaDokter = extras.getString("namaDokter");
        nomorAntrian= extras.getString("no_antrian");
        waktuAntrian= extras.getString("estimasi");

        //mendefinisikan variable dari shared preference
        namaPasien = getSharedPreferences("DATA", Context.MODE_PRIVATE).getString("nama","");
        norm = getSharedPreferences("data", Context.MODE_PRIVATE).getString("no_rm","");
        norujukan= extras.getString("no_rujukan");
        tanggalAntri= extras.getString("tanggal");
//        norujukan= getSharedPreferences("simpan", Context.MODE_PRIVATE).getString("no_rujuk","");
//        tanggalAntri= getSharedPreferences("simpan", Context.MODE_PRIVATE).getString("tanggal","");

        PasienView.setText(namaPasien);
        PoliView.setText(poli);
        DokterView.setText(namaDokter);
        RujukanView.setText(norujukan);
        TglView.setText(tanggalAntri);
        NoAntrianView.setText(nomorAntrian);
        waktuView.setText(waktuAntrian);


    }
    // mendefiniskan ketika button di click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_batal_antri:
                Toast.makeText(this, "Selesai Mendaftar Antrian", Toast.LENGTH_SHORT).show();
                Intent IntenOut = new Intent(DetailKartuAntrianActivity.this, MenuActivity.class);
                startActivity(IntenOut);

                finish();
                break;

            case R.id.btn_tanya_admin:
//                Intent IntenOut = new Intent(MenuActivity.this, FinishedActivity.class);
//                startActivity(IntenOut);
                Toast.makeText(this, "anda bertanya kepada admin", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

}
