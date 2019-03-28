package com.simpus.antrianpasienonline;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Button dafAntrian, antrianSaya;
    TextView txt_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //mendefinisikan variable
        dafAntrian =(Button)findViewById(R.id.dafAntrian );
        antrianSaya =(Button)findViewById(R.id.antrianSaya );
        txt_username = (TextView)findViewById(R.id.txt_username);

        //mendefinisikan click listener
        dafAntrian.setOnClickListener(this);
        antrianSaya.setOnClickListener(this);

        //mengubah tulisan username
        txt_username.setText(getSharedPreferences("data", Context.MODE_PRIVATE).getString("username",""));
    }

    // mendefiniskan ketika button di click
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dafAntrian:
                Intent IntentIn = new Intent(MenuActivity.this, PilihTanggalActivity.class);
                startActivity(IntentIn);

                break;

            case R.id.antrianSaya:
//                Intent IntenOut = new Intent(MenuActivity.this, FinishedActivity.class);
//                startActivity(IntenOut);
                Toast.makeText(this, "anda memilih antrian saya", Toast.LENGTH_SHORT).show();
                break;

        }
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
