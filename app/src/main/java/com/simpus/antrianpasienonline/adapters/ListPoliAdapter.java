package com.simpus.antrianpasienonline.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simpus.antrianpasienonline.R;
import com.simpus.antrianpasienonline.objects.poli;

import java.util.ArrayList;

public class ListPoliAdapter extends RecyclerView.Adapter<ListPoliViewHolder> {

    private Context context;
    public static ArrayList<poli> data;

    public ListPoliAdapter(Context context, ArrayList<poli> data){
        super();
        this.context = context;
        this.data = data;

    }

    @Override
    public ListPoliViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_poli, null);
        ListPoliViewHolder view = new ListPoliViewHolder(layoutView);
        return view;
    }

    @Override
    public void onBindViewHolder(ListPoliViewHolder holder, int position){
        holder.poliView.setText(data.get(position).getPoli());
    }

    @Override
    public int getItemCount(){
        return data.size();
    }
}
