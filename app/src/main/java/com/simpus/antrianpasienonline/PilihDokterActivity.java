package com.simpus.antrianpasienonline;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.simpus.antrianpasienonline.adapters.ListDokterAdapter;
import com.simpus.antrianpasienonline.adapters.ListPoliAdapter;
import com.simpus.antrianpasienonline.objects.Dokter;
import com.simpus.antrianpasienonline.objects.poli;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PilihDokterActivity extends AppCompatActivity {
    Button btn_next;
    RecyclerView recyclerDokterView;
    ArrayList<Dokter>data;
    ListDokterAdapter adapter;
    private String idpoli, poli;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_dokter);

        btn_next =(Button)findViewById(R.id.btn_next );

        //mendefinisikan recycler View
        recyclerDokterView =(RecyclerView) findViewById(R.id.recyclerDokterView);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intentantrian = new Intent(PilihDokterActivity.this, KartuAntrianActivity.class);
                startActivity(Intentantrian);
            }
        });

        //mengambil intent dari intent sebelumnya
        Bundle extras = getIntent().getExtras();
        idpoli = extras.getString("idpoli");
        poli = extras.getString("idpoli");


        //mengambil data dari database
        getData();
    }
    public void getData(){
        final String tanggal = getSharedPreferences("simpan", Context.MODE_PRIVATE).getString("tanggal","");

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sedang Mengambil Data...");
        progressDialog.show();
        String url;
        url = "http://apitest.kinaryatama.id/sms/list_jadwal.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("DEBUGS", response.toString());
                try {

                    data = new ArrayList<Dokter> ();
                    JSONArray arrayResponse = new JSONArray(response);
                    for (int i=0; i<arrayResponse.length();i++){
                        JSONObject object = arrayResponse.getJSONObject(i);
                        String id_jadwal =object.getString("id_jadwal");
                        String poli = object.getString("poli");
                        String nama = object.getString("nama");
                        String spesialis = object.getString("spesialis");
                        String start = object.getString("start");
                        String end = object.getString("end");
                        String kuota = object.getString("kuota");
                        String terisi = object.getString("terisi");

                        data.add(new Dokter (id_jadwal,poli,nama,spesialis,start,end,kuota,terisi));

                        //menambah data ke recycleview
                        LinearLayoutManager layoutManager= new
                                LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                                false);
                        recyclerDokterView.setHasFixedSize(true);
                        recyclerDokterView.setLayoutManager(layoutManager);
                        adapter = new
                                ListDokterAdapter(PilihDokterActivity.this, data);
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                        recyclerDokterView.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("DEBUGS", "Error: " + error.getMessage());
                progressDialog.dismiss();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                //menambahkan parameter post, nama put sama dengan nama variable pada webservice PHP
                params.put("tanggal",tanggal);
                params.put("idpoli",idpoli);

                return params;
            }
        };

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
