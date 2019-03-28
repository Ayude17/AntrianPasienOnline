package com.simpus.antrianpasienonline.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simpus.antrianpasienonline.R;
import com.simpus.antrianpasienonline.objects.Dokter;
import com.simpus.antrianpasienonline.objects.Histori;

import java.util.ArrayList;

public class ListHistoriAntrianAdapter extends RecyclerView.Adapter<ListHistoriAntrianViewHolder> {

    private Context context;
    public static ArrayList<Histori> dataHistori;

    public ListHistoriAntrianAdapter(Context context, ArrayList<Histori> data_histori) {
        super();
        this.context = context;
        this.dataHistori = data_histori;
    }
    @Override
    public ListHistoriAntrianViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_histori_antrian, null);
        ListDokterViewHolder view = new ListDokterViewHolder(layoutView);
        return view;
    }
    @Override
    public void onBindViewHolder(ListDokterViewHolder holder, int position){
        holder.tglHistoriView.setText(dataHistori.get(position).getTanggal_antri());
        holder.noAntrianHistoriView.setText(dataHistori.get(position).getNo_antrian());
        holder.poliHistoriView.setText(dataHistori.get(position).getPoli());
    }

    @Override
    public int getItemCount(){
        return dataHistori.size();
    }



}
