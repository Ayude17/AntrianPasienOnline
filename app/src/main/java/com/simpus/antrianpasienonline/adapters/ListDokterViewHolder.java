package com.simpus.antrianpasienonline.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.simpus.antrianpasienonline.R;

public class ListDokterViewHolder extends RecyclerView.ViewHolder {
    TextView namaDokterView, poliView, kuotaView;

    public ListDokterViewHolder(View itemView){
        super(itemView);
        namaDokterView = (TextView)itemView.findViewById(R.id.namaDokterView);
        poliView = (TextView)itemView.findViewById(R.id.poliView);
        kuotaView = (TextView)itemView.findViewById(R.id.kuotaView);
    }
}
