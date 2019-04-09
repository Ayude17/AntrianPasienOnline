package com.simpus.antrianpasienonline;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import android.support.v4.app.DialogFragment;

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
import com.simpus.antrianpasienonline.Fragment.PoliFragment;
import com.simpus.antrianpasienonline.adapters.ListPoliAdapter;
import com.simpus.antrianpasienonline.objects.poli;
import com.simpus.antrianpasienonline.adapters.SpinnerAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DaftarAntriActivity extends AppCompatActivity {
    Button btn_lanjut1,btnPoliView;
    CalendarView calendarView;
    SharedPreferences simpan;
    poli kode_poli;
    EditText RujukanView,TglView;
    Spinner PoliView;
    ArrayList<poli> listPoli;
    TextView polipilih;
    private SpinnerAdapter adapter;
    private int mYear, mMonth, mDay;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_antri);

        //inisiasi calendar
        TglView = (EditText) findViewById(R.id.TglView);
        RujukanView = (EditText) findViewById(R.id.RujukanView);
        PoliView= (Spinner) findViewById(R.id.PoliView);
        polipilih= (TextView) findViewById(R.id.polipilih);



        //inisiasi sharedpreferences
        simpan = getSharedPreferences("simpan", Context.MODE_PRIVATE);


        //membuat tanggal
        TglView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(DaftarAntriActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                month = month + 1;
                                String formattedMonth = "" + month;
                                String formattedDayOfMonth = "" + dayOfMonth;
                                if(month < 10){

                                    formattedMonth = "0" + month;
                                }
                                if(dayOfMonth < 10){

                                    formattedDayOfMonth = "0" + dayOfMonth;
                                }

                                TglView.setText(year + "-" + formattedMonth + "-" +formattedDayOfMonth );
                                getPoli();
                            }
                        }, mYear,mMonth,mDay);
                datePickerDialog.show();

            }
        });



        //menginisiasikan button
        btn_lanjut1= (Button) findViewById(R.id.btn_lanjut1);
        btnPoliView= (Button) findViewById(R.id.btnPoliView);

        btn_lanjut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intentpoli = new Intent(DaftarAntriActivity.this, DaftarActivity.class);
                startActivity(Intentpoli);
                //inisiasi dan menyimpan file ke dalam sharedpreferences
                simpan = getSharedPreferences("simpan", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = simpan.edit();
                editor.putString("tanggal", TglView.getText().toString());
                editor.putString("no_rujuk", RujukanView.getText().toString());
                editor.commit();
            }
        });

        //inisiasi fragment
        final FragmentManager fm=getFragmentManager();
        final  PoliFragment tampil=new PoliFragment();
        btnPoliView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //inisiasi fragment
//                final FragmentManager fm=getFragmentManager();
//                final  PoliFragment tampil=new PoliFragment();
                //mengirim data ke PoliFragment
                Bundle bundle = new Bundle();
                bundle.putString("tanggal",TglView.getText().toString());

                PoliFragment fragobj = new PoliFragment();
                fragobj.setArguments(bundle);
                getSupportFragmentManager();
            }
        });

    }


    public void getPoli(){
        final String tanggal = TglView.getText().toString();
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

                    listPoli = new ArrayList<poli>();
                    JSONArray arrayResponse = new JSONArray(response);
                    for (int i=0; i<arrayResponse.length();i++){
                        JSONObject object = arrayResponse.getJSONObject(i);
                        String id_poli =object.getString("id_poli");
                        String poli = object.getString("poli");


                        listPoli.add(new poli (id_poli,poli));
                        }

                        adapter= new SpinnerAdapter(DaftarAntriActivity.this,
                                android.R.layout.simple_spinner_item,
                                listPoli);
                    PoliView.setAdapter(adapter);
                    PoliView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view,
                                                   int position, long id) {
                            // Here you get the current item (a User object) that is selected by its position
                            poli item = adapter.getItem(position);
                            // Here you can do the action you want to...

                            Log.d("DEBUGS ITEM ", item.getPoli());
                            //getDesa(item.getId_poli());
                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterKecamatan) {  }
                    });
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
}
