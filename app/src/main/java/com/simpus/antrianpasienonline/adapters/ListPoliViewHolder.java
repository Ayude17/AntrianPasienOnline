package com.simpus.antrianpasienonline.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simpus.antrianpasienonline.R;

public class ListPoliViewHolder extends RecyclerView.ViewHolder {
    TextView poliView;

    public ListPoliViewHolder(View itemView){
        super(itemView);
        TextView poliView = (TextView)itemView.findViewById(R.id.poliView);
    }
}
