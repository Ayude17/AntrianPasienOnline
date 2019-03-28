package com.simpus.antrianpasienonline;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.simpus.antrianpasienonline.adapters.ListDokterAdapter;
import com.simpus.antrianpasienonline.adapters.ListHistoriAntrianAdapter;
import com.simpus.antrianpasienonline.objects.Dokter;
import com.simpus.antrianpasienonline.objects.Histori;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CekHistoriAntrianActivity extends AppCompatActivity {
    RecyclerView recyclerhistoryView;
    ArrayList<Histori> dataHistori;
    ListHistoriAntrianAdapter adapter;
    private String norm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek_histori_antrian);
        recyclerhistoryView =(RecyclerView) findViewById(R.id.recyclerhistoriView);
        norm = getSharedPreferences("DATA", Context.MODE_PRIVATE).getString("no_rm","");

        //mengambil data dari database
        getData();


    }
    public void getData(){


        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sedang Mengambil Data...");
        progressDialog.show();
        String url;
        url = "http://apitest.kinaryatama.id/sms/list_history.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("DEBUGS", response.toString());
                try {

                    dataHistori = new ArrayList<Histori> ();
                    JSONArray arrayResponse = new JSONArray(response);
                    for (int i=0; i<arrayResponse.length();i++){
                        JSONObject object = arrayResponse.getJSONObject(i);
                        String id =object.getString("id");
                        String id_poli = object.getString("id_poli");
                        String id_dokter = object.getString("id_dokter");
                        String id_jadwal = object.getString("id_jadwal");
                        String no_antrian = object.getString("no_antrian");
                        String no_rm = object.getString("no_rm");
                        String no_rujukan = object.getString("no_rujukan");
                        String tanggal = object.getString("tanggal");
                        String waktu_antri = object.getString("waktu_antri");
                        String hadir = object.getString("hadir");
                        String batal = object.getString("batal");
                        String start = object.getString("start");
                        String dokter = object.getString("dokter");
                        String poli = object.getString("poli");
                        String estimasi = object.getString("estimasi");

                        dataHistori.add(new Histori (id,id_poli,id_dokter,id_jadwal,no_antrian,no_rm,no_rujukan,tanggal,waktu_antri,hadir,batal,start,dokter,poli,estimasi));

                        //menambah data ke recycleview
                        LinearLayoutManager layoutManager= new
                                LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                                false);
                        recyclerhistoryView.setHasFixedSize(true);
                        recyclerhistoryView.setLayoutManager(layoutManager);
                        adapter = new
                                ListHistoriAntrianAdapter(CekHistoriAntrianActivity.this, dataHistori);
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                        recyclerhistoryView.setAdapter(adapter);
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
                params.put("norm",norm);

                return params;
            }
        };

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
