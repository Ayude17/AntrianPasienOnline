package com.simpus.antrianpasienonline.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.simpus.antrianpasienonline.PilihDokterActivity;
import com.simpus.antrianpasienonline.R;

public class ListPoliViewHolder extends RecyclerView.ViewHolder {
    TextView poliView;

    public ListPoliViewHolder(View itemView){
        super(itemView);
        poliView = (TextView)itemView.findViewById(R.id.poliView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil posisi item
                int position = getAdapterPosition();

                //membuat inten untuk menjalankan activity baru
                Intent intent = new Intent(view.getContext(), PilihDokterActivity.class);
                intent.putExtra("idpoli", ListPoliAdapter.data.get(position).getId_poli());
                intent.putExtra("poli", ListPoliAdapter.data.get(position).getPoli());
                //menjalankan intent
                view.getContext().startActivity(intent);

            }
        });
    }
}

