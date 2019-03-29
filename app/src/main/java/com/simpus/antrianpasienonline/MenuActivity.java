package com.simpus.antrianpasienonline;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Button dafAntrian, antrianSaya, btnlogout;
    TextView txt_username;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //mendefinisikan variable
        dafAntrian =(Button)findViewById(R.id.dafAntrian );
        antrianSaya =(Button)findViewById(R.id.antrianSaya );
        btnlogout = (Button) findViewById(R.id.btn_logout);
        txt_username = (TextView)findViewById(R.id.txt_username);

        //mendefinisikan click listener
        dafAntrian.setOnClickListener(this);
        antrianSaya.setOnClickListener(this);
        btnlogout.setOnClickListener(this);
        username = getSharedPreferences("DATA", Context.MODE_PRIVATE).getString("nama","");

                //mengubah tulisan username
        txt_username.setText(username);
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
                Intent IntenOut = new Intent(MenuActivity.this, CekHistoriAntrianActivity.class);
                startActivity(IntenOut);
                Toast.makeText(this, "anda memilih antrian saya", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_logout:
                SharedPreferences sharedPreferences = getSharedPreferences("DATA", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("login", false);
//                editor.putString(TAG_USERNAME,null);
                editor.commit();

                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;

//                return true;
        }
//        return super.onOptionsItemSelected(v);
    }
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
