package com.rifky.simlik.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rifky.simlik.R;
import com.rifky.simlik.model.NomorPenting;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rifky on 07/05/17.
 */

public class NomorPentingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NomorPenting> dataNomorPentings;
    private Context context;

    public NomorPentingAdapter(List<NomorPenting> dataNomorPentings, Context context) {
        this.dataNomorPentings = dataNomorPentings;
        this.context = context;
    }

    @Override
    public ViewHolderNomorPenting onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nomor_penting, parent, false);
        return new ViewHolderNomorPenting(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderNomorPenting)holder).bindData(dataNomorPentings.get(position));
    }

    @Override
    public int getItemCount() {
        return dataNomorPentings.size();
    }

    static class ViewHolderNomorPenting extends RecyclerView.ViewHolder {
        @BindView(R.id.nama_telepon)
        TextView namaTelepon;
        @BindView(R.id.nomor_telepon)
        TextView nomorTelepon;
        @BindView(R.id.cardview_item_nomor_penting)
        CardView cardViewNomor;

        ViewHolderNomorPenting(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(final NomorPenting data) {
            this.namaTelepon.setText(data.getNama());
            this.nomorTelepon.setText(data.getTelepon());
            this.cardViewNomor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intentTelepon = new Intent(Intent.ACTION_DIAL, Uri.parse(new StringBuilder().append("tel:").append(data.getTelepon()).toString()));
                    v.getContext().startActivity(intentTelepon);
                }
            });
        }
    }
}

