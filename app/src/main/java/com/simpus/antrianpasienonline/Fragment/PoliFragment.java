package com.simpus.antrianpasienonline.Fragment;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.simpus.antrianpasienonline.AppController;
import com.simpus.antrianpasienonline.PilihPoliActivity;
import com.simpus.antrianpasienonline.R;
import com.simpus.antrianpasienonline.adapters.ListPoliAdapter;
import com.simpus.antrianpasienonline.objects.poli;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PoliFragment extends DialogFragment {
    RecyclerView list_poliView;
    ArrayList<poli> data;
    ListPoliAdapter adapter;
    // this method create view for your Dialog
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //inflate layout with recycler view
        View v = inflater.inflate(R.layout.poli_alert_dialog, container, true);
        list_poliView = (RecyclerView) v.findViewById(R.id.list_poliView);
        getData();

        //setadapter
        //get your recycler view and populate it.
        this.getDialog().setTitle("POLI");
        return v;
    }
    public void getData(){
        final String tanggal = getArguments().getString("tanggal");
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
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
                                LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
                                false);
                        list_poliView.setHasFixedSize(true);
                        list_poliView.setLayoutManager(layoutManager);
                        adapter = new
                                ListPoliAdapter(getContext(), data);
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


}

