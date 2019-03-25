package com.simpus.antrianpasienonline.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simpus.antrianpasienonline.R;

public class ListPoliViewHolder extends RecyclerView.ViewHolder {
    Button poliView;

    public ListPoliViewHolder(View itemView){
        super(itemView);
        Button poliView = (Button)itemView.findViewById(R.id.poliView);
    }
}
