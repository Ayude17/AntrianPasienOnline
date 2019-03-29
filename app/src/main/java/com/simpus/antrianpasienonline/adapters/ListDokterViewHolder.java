package com.simpus.antrianpasienonline.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.simpus.antrianpasienonline.KonfirmasiActivity;
import com.simpus.antrianpasienonline.R;

public class ListDokterViewHolder extends RecyclerView.ViewHolder {
    TextView namaDokterView, poliView, kuotaView;

    public ListDokterViewHolder(View itemView){
        super(itemView);
        namaDokterView = (TextView)itemView.findViewById(R.id.namaDokterView);
        poliView = (TextView)itemView.findViewById(R.id.poliView);
        kuotaView = (TextView)itemView.findViewById(R.id.kuotaView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil posisi item
                int position = getAdapterPosition();
                //membuat inten untuk menjalankan activity baru
                Intent intent = new Intent(view.getContext(), KonfirmasiActivity.class);
                intent.putExtra("id_jadwal", ListDokterAdapter.data.get(position).getId_jadwal());
                intent.putExtra("poli", ListDokterAdapter.data.get(position).getPoli());
                intent.putExtra("namaDokter", ListDokterAdapter.data.get(position).getNama());
                intent.putExtra("spesialis", ListDokterAdapter.data.get(position).getSpesialis());
                intent.putExtra("start", ListDokterAdapter.data.get(position).getStart());
                intent.putExtra("end", ListDokterAdapter.data.get(position).getEnd());
                intent.putExtra("kuota", ListDokterAdapter.data.get(position).getKuota());
                intent.putExtra("terisi", ListDokterAdapter.data.get(position).getTerisi());
                //menjalankan intent
                view.getContext().startActivity(intent);

            }
        });
    }
}

