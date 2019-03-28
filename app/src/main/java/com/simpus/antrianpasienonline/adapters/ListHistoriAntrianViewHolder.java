package com.simpus.antrianpasienonline.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.simpus.antrianpasienonline.KonfirmasiActivity;
import com.simpus.antrianpasienonline.R;

public class ListHistoriAntrianViewHolder extends RecyclerView.ViewHolder{
    TextView tglHistoriView, noAntrianHistoriView, poliHistoriView;

    public ListHistoriAntrianViewHolder(View itemView){
        super(itemView);
        tglHistoriView = (TextView)itemView.findViewById(R.id.histori_tgl_antri);
        noAntrianHistoriView = (TextView)itemView.findViewById(R.id.histori_no_antrian);
        poliHistoriView = (TextView)itemView.findViewById(R.id.histori_nama_poli);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mengambil posisi item
                int position = getAdapterPosition();
                //membuat inten untuk menjalankan activity baru
                Intent intent = new Intent(view.getContext(), KonfirmasiActivity.class);
                intent.putExtra("no_antrian", ListDokterAdapter.data.get(position).getNo_antrian());
                intent.putExtra("tanggal_antrian", ListDokterAdapter.data.get(position).getTanggal_antri());
                intent.putExtra("poli", ListDokterAdapter.data.get(position).getPoli());
                intent.putExtra("dokter", ListDokterAdapter.data.get(position).getDokter());
                intent.putExtra("no_rujukan", ListDokterAdapter.data.get(position).getNo_rujukan());

                //menjalankan intent
                view.getContext().startActivity(intent);

            }
        });
    }

}
