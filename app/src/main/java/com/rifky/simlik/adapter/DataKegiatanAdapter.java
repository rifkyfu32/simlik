package com.rifky.simlik.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rifky.simlik.R;
import com.rifky.simlik.model.Data;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rifky on 07/05/17.
 */

public class DataKegiatanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Data> dataKegiatans;
    private Context context;

    public DataKegiatanAdapter(List<Data> dataKegiatans, Context context) {
        this.dataKegiatans = dataKegiatans;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data_kegiatan, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bindData(dataKegiatans.get(position));
    }

    @Override
    public int getItemCount() {
        return dataKegiatans.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ln_background_status)
        LinearLayout ln;
        @BindView(R.id.status)
        TextView status;
        @BindView(R.id.acara)
        TextView acara;
        @BindView(R.id.tempat)
        TextView tempat;
        @BindView(R.id.keterangan)
        TextView keterangan;
        @BindView(R.id.waktu)
        TextView waktu;
        @BindView(R.id.cardViewKegiatan)
        CardView cardView;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(final Data data) {
            if (data.getStatus().equalsIgnoreCase("Belum Terlaksana")) {
                this.ln.setBackgroundColor(Color.parseColor("#F44336"));
            }else if(data.getStatus().equalsIgnoreCase("Terlaksana")){
                this.ln.setBackgroundColor(Color.parseColor("#4CAF50"));
            }else{
                this.ln.setBackgroundColor(Color.parseColor("#FFC107"));
            }
            this.status.setText(data.getStatus());
            this.acara.setText(data.getAcara());
            this.tempat.setText(data.getTempat());
            this.keterangan.setText(String.format("Keterangan : %s", data.getKeterangan()));
            this.waktu.setText("waktu : " + data.getWaktu() + ", " + data.getMulai() + " s/d " + data.getSelesai());
            this.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + data.getTempat());
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    v.getContext().startActivity(mapIntent);
                }
            });
        }

    }
}