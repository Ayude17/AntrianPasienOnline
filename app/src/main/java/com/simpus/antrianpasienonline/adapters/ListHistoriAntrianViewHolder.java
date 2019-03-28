package com.simpus.antrianpasienonline.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.simpus.antrianpasienonline.DetailKartuAntrianActivity;
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
                Intent intent = new Intent(view.getContext(), DetailKartuAntrianActivity.class);
                intent.putExtra("id", ListHistoriAntrianAdapter.dataHistori.get(position).getId());
                intent.putExtra("id_poli", ListHistoriAntrianAdapter.dataHistori.get(position).getId_poli());
                intent.putExtra("id_dokter", ListHistoriAntrianAdapter.dataHistori.get(position).getDokter());
                intent.putExtra("id_jadwal", ListHistoriAntrianAdapter.dataHistori.get(position).getId_jadwal());
                intent.putExtra("no_antrian", ListHistoriAntrianAdapter.dataHistori.get(position).getNo_antrian());
                intent.putExtra("no_rm", ListHistoriAntrianAdapter.dataHistori.get(position).getNo_rm());
                intent.putExtra("no_rujukan", ListHistoriAntrianAdapter.dataHistori.get(position).getNo_rujukan());
                intent.putExtra("tanggal", ListHistoriAntrianAdapter.dataHistori.get(position).getTanggal());
                intent.putExtra("waktu_antri", ListHistoriAntrianAdapter.dataHistori.get(position).getWaktu_antri());
                intent.putExtra("hadir", ListHistoriAntrianAdapter.dataHistori.get(position).getHadir());
                intent.putExtra("batal", ListHistoriAntrianAdapter.dataHistori.get(position).getBatal());
                intent.putExtra("start", ListHistoriAntrianAdapter.dataHistori.get(position).getStart());
                intent.putExtra("namaDokter", ListHistoriAntrianAdapter.dataHistori.get(position).getDokter());
                intent.putExtra("poli", ListHistoriAntrianAdapter.dataHistori.get(position).getPoli());
                intent.putExtra("estimasi", ListHistoriAntrianAdapter.dataHistori.get(position).getEstimasi());


                //menjalankan intent
                view.getContext().startActivity(intent);

            }
        });
    }

}
