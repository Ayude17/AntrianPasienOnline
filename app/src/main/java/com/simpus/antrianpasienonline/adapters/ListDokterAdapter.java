package com.simpus.antrianpasienonline.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simpus.antrianpasienonline.R;
import com.simpus.antrianpasienonline.objects.Dokter;

import java.util.ArrayList;

public class ListDokterAdapter extends RecyclerView.Adapter<ListDokterViewHolder> {

    private Context context;
    private Integer KuotaPas, TerisiPas, SisaPas;
    public static ArrayList<Dokter> data;

    public ListDokterAdapter(Context context, ArrayList<Dokter> data){
        super();
        this.context = context;
        this.data = data;



    }

    @Override
    public ListDokterViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listdokter, null);
        ListDokterViewHolder view = new ListDokterViewHolder(layoutView);
        return view;
    }

    @Override
    public void onBindViewHolder(ListDokterViewHolder holder, int position){


        KuotaPas =Integer.valueOf(data.get(position).getKuota());
        TerisiPas =Integer.valueOf(data.get(position).getTerisi());
        SisaPas= KuotaPas - TerisiPas;

        holder.namaDokterView.setText(data.get(position).getNama());
        holder.poliView.setText(data.get(position).getPoli());
        holder.kuotaView.setText(SisaPas.toString());
    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
