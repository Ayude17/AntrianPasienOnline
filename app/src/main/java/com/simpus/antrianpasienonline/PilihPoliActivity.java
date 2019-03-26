package com.simpus.antrianpasienonline;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.simpus.antrianpasienonline.adapters.ListPoliAdapter;
import com.simpus.antrianpasienonline.objects.poli;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PilihPoliActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_kembali2,btn_lanjut2;
    RecyclerView list_poliView;
    ArrayList<poli>data;
    ListPoliAdapter adapter;


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

        //mendefinisikan recycler View
        list_poliView =(RecyclerView) findViewById(R.id.list_poliView );

        //mengambil data dari database
        getData();

    }
    public void getData(){
        final String tanggal = "2019-03-25";
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Sedang Mengambil Data...");
        progressDialog.show();
        String url;
        url = "http://apitest.kinaryatama.id/sms/list_jadwal_poli.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("DEBUGS", response.toString());
                try {

                    data = new ArrayList<poli>();
                    JSONArray arrayResponse = new JSONArray(response);
                    for (int i=0; i<arrayResponse.length();i++){
                        JSONObject object = arrayResponse.getJSONObject(i);
                        String id_poli =object.getString("id_poli");
                        String poli = object.getString("poli");


                        data.add(new poli (id_poli,poli));


                        //menambah data ke recycleview
                        LinearLayoutManager layoutManager= new
                                LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                                false);
                        list_poliView.setHasFixedSize(true);
                        list_poliView.setLayoutManager(layoutManager);
                        adapter = new
                                ListPoliAdapter(PilihPoliActivity.this, data);
                        adapter.notifyDataSetChanged();
                        progressDialog.dismiss();
                        list_poliView.setAdapter(adapter);


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

                return params;
            }
        };

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest);
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
