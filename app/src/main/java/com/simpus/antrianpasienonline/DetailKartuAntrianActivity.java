package com.simpus.antrianpasienonline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailKartuAntrianActivity extends AppCompatActivity implements View.OnClickListener  {
    private Button btn_batal_antri,btn_tanya_admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kartu_antrian);
        btn_batal_antri =(Button)findViewById(R.id.btn_batal_antri );
        btn_tanya_admin =(Button)findViewById(R.id.btn_tanya_admin );

        //mendefinisikan onclick listener
        btn_batal_antri.setOnClickListener(this);
        btn_tanya_admin.setOnClickListener(this);

    }
    // mendefiniskan ketika button di click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_batal_antri:
                Toast.makeText(this, "antrian dibatalkan", Toast.LENGTH_SHORT).show();
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
