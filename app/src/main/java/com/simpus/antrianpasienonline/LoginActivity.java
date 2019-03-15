package com.simpus.antrianpasienonline;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private String id_pasien;
    EditText edtNik,edtPswd;
    Button btnLogin, btnRegis;
    SharedPreferences sharedPreferences;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtNik = (EditText) findViewById(R.id.edt_nik);
        edtPswd = (EditText) findViewById(R.id.edt_pswd);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnRegis = (Button) findViewById(R.id.btn_regis);

        sharedPreferences = getSharedPreferences("DATA", Context.MODE_PRIVATE);
//button LOGIN
        btnLogin.setOnClickListener(new View.OnClickListener() {
            //mengaktifkan button untuk login
            @Override
            public void onClick(View view) {
                if (!edtNik.getText().toString().equals("") || !edtPswd.getText().toString().equals(""))
                {
                    postLogin();
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"NIK atau Password belum terisi", Toast.LENGTH_LONG).show();
                }
            }
        });
// button DAFTAR
        btnRegis.setOnClickListener(new View.OnClickListener() {
            //onClick untuk button Daftar
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, DaftarActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void postLogin(){
        //algoritma untuk POST login
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, //request post
                "http://apitest.kinaryatama.id/antrian.android/loginpasien.php",
                new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        Log.d("CREATE", response);
                        try{
                            //mengubah string menjadi jsonObject
                            JSONObject object = new JSONObject(response);
                            //mendapatkan string dari status
                            String status = object.getString("status");
                            //jika berhasil ditambahkan
                            if(status.equalsIgnoreCase("success")){
                                //Menyimpan data Login
                                JSONObject loginData = object.getJSONObject("data");
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putBoolean("login", true);
                                editor.putString("nama", loginData.getString("nama"));
                                editor.putString("tgl_lahir", loginData.getString("tgl_lahir"));
                                editor.putString("nik", loginData.getString("nik"));
                                editor.putString("no_rm", loginData.getString("no_rm"));
                                editor.putString("no_jaminan", loginData.getString("no_jaminan"));
                                editor.putString("alamat", loginData.getString("alamat"));
                                editor.putString("jenis_kelamin", loginData.getString("jk"));
                                editor.putString("no_hp", loginData.getString("no_hp"));


                                editor.commit();

                                //menampilkan pesan berhasil
                                Toast.makeText(LoginActivity.this,object.getString("message"),Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(LoginActivity.this,MenuActivity.class);
                                startActivity(intent);
                                progressDialog.dismiss();
                                finish();
                            }else {
                                //menampilkan pesan gagal
                                Log.d("CREATE", status);
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
                            }
                        }catch (Exception e){
                            Log.d("CREATE", e.toString());
                            progressDialog.dismiss();
                        }
                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        Log.d("CREATE", error.toString());
                        Toast.makeText(LoginActivity.this,"Error, Login Gagal <!>",Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                    }
                }){

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                //menambahkan parameter post, nama put sama dengan nama variable pada webservice PHP
                params.put("nik", edtNik.getText().toString());
                params.put("password", edtPswd.getText().toString());

                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    @Override
    public void onBackPressed() {
        // tombol keluar aplikasi
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan tombol back sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
