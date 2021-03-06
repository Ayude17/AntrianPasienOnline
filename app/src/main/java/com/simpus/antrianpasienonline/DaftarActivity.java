package com.simpus.antrianpasienonline;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener {
    //public class DaftarActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    Button btnDaftar, btnMasuk, btnTglLhr;
    EditText edtNama, edtTglLhr, edtNIK, edtNoRM, edtNoJaminan, edtAlamat, edtNoHP, edtPswd;
    private int mYear, mMonth, mDay;
    String nama, jk, tgl_lahir, nik, noRM, noJaminan, alamat, noHP, pswd;
    RadioGroup RGgender;
    RadioButton radLK, radPR;
    private RadioButton radioButton;
    boolean doubleBackToExitPressedOnce = false;
    SharedPreferences daftar;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        //        button

        btnMasuk = (Button) findViewById(R.id.btn_masuk);
        btnMasuk.setOnClickListener(this);
        btnTglLhr = (Button) findViewById(R.id.btn_tglLahir);
        btnTglLhr.setOnClickListener(this);
        //        Radio group
        RGgender = (RadioGroup) findViewById(R.id.gender);
        radLK = (RadioButton) findViewById(R.id.rad_lk);
        radPR = (RadioButton) findViewById(R.id.rad_pr);
//            RGgender.setOnCheckedChangeListener(this);
        //        Edit Text
        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtTglLhr = (EditText) findViewById(R.id.edt_tglLahir);
        edtNIK = (EditText) findViewById(R.id.edt_nik);
        edtNoRM = (EditText) findViewById(R.id.edt_noRM);
        edtNoJaminan = (EditText) findViewById(R.id.edt_noJaminan);
        edtAlamat = (EditText) findViewById(R.id.edt_alamat);
        edtNoHP = (EditText) findViewById(R.id.ed_noHp);
        edtPswd = (EditText) findViewById(R.id.edt_pswd);

//        daftar = getSharedPreferences("daftar", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = daftar.edit();
//        editor.putString("nama", edtNama.toString());
//        editor.putString("tgl_lahir", edtTglLhr.toString());
//        editor.putString("nik", edtNIK.toString());
//        editor.putString("no_rm", edtNoRM.toString());
//        editor.putString("no_jaminan", edtNoJaminan.toString());
//        editor.putString("alamat", edtAlamat.toString());
//        editor.putString("no_hp", edtNoHP.toString());
//        editor.putString("password", edtPswd.toString());
//        editor.commit();

        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        btnDaftar.setOnClickListener(this);

//            btnDaftar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    postRegister();
//                }
//            });
//            btnMasuk.setOnClickListener(new View.OnClickListener() {
//                //onClick untuk button Daftar
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(DaftarActivity.this, LoginActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            });
    }

    @Override
    public void onClick(View v) {
        if (v == btnDaftar) {
            btnDaftar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    int selectedId = RGgender.getCheckedRadioButtonId();
//                     radioButton = (RadioButton) findViewById(selectedId);
//                     Toast.makeText(DaftarActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();

//                    nama = edtNama.getText().toString();
                    nama = getSharedPreferences("DATA", Context.MODE_PRIVATE).getString("nama","");
                    tgl_lahir = edtTglLhr.getText().toString();
//                    nik = edtNIK.getText().toString();
                    nik = getSharedPreferences("DATA", Context.MODE_PRIVATE).getString("nik","");
                    noRM = edtNoRM.getText().toString();
                    noJaminan = edtNoJaminan.getText().toString();
                    alamat = edtAlamat.getText().toString();
                    pswd = edtPswd.getText().toString();
                    postRegister();

                    //                    String nama, jk,tgl_lahir, nik, noRM, noJaminan, alamat, noHP, pswd;
                }
            });
        }
        if (v == btnMasuk) {
            //       button untuk membatalkan eksekusi
            btnMasuk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DaftarActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
        if (v == btnTglLhr) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            month = month + 1;
                            String formattedMonth = "" + month;
                            String formattedDayOfMonth = "" + dayOfMonth;
                            if (month < 10) {

                                formattedMonth = "0" + month;
                            }
                            if (dayOfMonth < 10) {

                                formattedDayOfMonth = "0" + dayOfMonth;
                            }

                            edtTglLhr.setText(year + "-" + formattedMonth + "-" + formattedDayOfMonth);
                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == radioButton){



        }
//        if (v == radLK) {
//            //       button untuk membatalkan eksekusi
//            btnMasuk.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    jk = "1";
//                }
//            });
//        }
//        if (v == radPR) {
//            //       button untuk membatalkan eksekusi
//            btnMasuk.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    jk = "2";
//                }
//            });
//        }
    }

    public void postRegister(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                "http://apitest.kinaryatama.id/sms/andro_daftar.php",
                //mengisi data petugas
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
                                //menampilkan pesan berhasil
                                progressDialog.dismiss();
                                Toast.makeText(DaftarActivity.this,object.getString("message"),Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(DaftarActivity.this,LoginActivity.class);
                                startActivity(intent);

                                finish();
                            }else {
                                //menampilkan pesan gagal
                                Log.d("CREATE", status);
                                progressDialog.dismiss();
                                Toast.makeText(DaftarActivity.this, object.getString("message"), Toast.LENGTH_LONG).show();
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
                        progressDialog.dismiss();
                        Toast.makeText(DaftarActivity.this,"Pastikan semua data telah terisi",Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                //menambahkan parameter post, nama put sama dengan nama variable pada webservice PHP
                params.put("nama", nama);
//                params.put("jk"), jk;
                params.put("tgl_lahir", tgl_lahir);
                params.put("nik", nik);
                params.put("no_rm", noRM);
                params.put("no_jaminan", noJaminan);
                params.put("alamat", alamat);
                params.put("no_hp", noHP);
                params.put("password", pswd);

                Log.d("usertes", nama);

                return params;
            }
        };
//        //mengecek eror handling field
//        boolean check_nama = true;
//        boolean check_jk = true;
//        boolean check_tglLahir = true;
//        boolean check_nik = true;
//        boolean check_noRM = true;
//        boolean check_NoJaminan = true;
//        boolean check_alamat = true;
//        boolean check_noHP = true;
//        boolean check_password = true;
//
//        if(edtNama.getText().toString().equals("")){
//            check_nama = false;
////        }else if(edt.getText().toString().equals("")){
////            check_jk = false;
//        }else if(edtTglLhr.getText().toString().equals("")){
//            check_tglLahir = false;
//        }else if(edtNIK.getText().toString().equals("")){
//            check_nik = false;
//        }else if(edtNoRM.getText().toString().equals("")){
//            check_noRM = false;
//        }else if(edtNoJaminan.getText().toString().equals("")){
//            check_NoJaminan = false;
//        }else if(edtAlamat.getText().toString().equals("")){
//            check_alamat = false;
//        }else if(edtNoHP.getText().toString().equals("")){
//            check_noHP = false;
//        }else if(edtPswd.getText().toString().equals("")){
//            check_password = false;
//        }
//
//        //mengeluarkan pesan handling
//        if(!check_nama){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_jk){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_tglLahir){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_nik){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_noRM){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_NoJaminan){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_alamat){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data  Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_noHP){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }else if(!check_password){
//            progressDialog.dismiss();
//            Toast.makeText(DaftarActivity.this,"Data Belum Terisi!!",Toast.LENGTH_LONG).show();
//        }
//
//        if(check_nama && check_jk && check_tglLahir && check_nik && check_noRM && check_NoJaminan && check_alamat && check_noHP && check_password){
//            AppController.getInstance().addToRequestQueue(stringRequest);
//        }
        AppController.getInstance().addToRequestQueue(stringRequest);
    }

    @Override
    //untuk keluar dari aplikasi
    public void onBackPressed() {
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

