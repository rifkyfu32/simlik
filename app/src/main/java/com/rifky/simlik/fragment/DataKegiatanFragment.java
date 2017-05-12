package com.rifky.simlik.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rifky.simlik.R;
import com.rifky.simlik.adapter.DataKegiatanAdapter;
import com.rifky.simlik.helper.RecyclerViewEmptySupport;
import com.rifky.simlik.helper.Utils;
import com.rifky.simlik.model.Data;
import com.rifky.simlik.model.Kegiatan;
import com.rifky.simlik.service.ServiceApi;
import com.rifky.simlik.service.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rifky on 07/05/17.
 */

public class DataKegiatanFragment extends Fragment {
    private static final String TAG = "DataKegiatanFragment";
    @BindView(R.id.rv_data_kegiatan)
    RecyclerViewEmptySupport recyclerView;
    @BindView(R.id.keteranganKegiatan)
    TextView keterangan;
    @BindView(R.id.txtKegiatanKosong)
    TextView textKosong;
    private ServiceApi api;
    private DataKegiatanAdapter adapter;
    private List<Data> listDataPasars;
    private String bulan,tahun;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.recycler_data_kegiatan,container,false);
        unbinder = ButterKnife.bind(DataKegiatanFragment.this, fragmentView);
        listDataPasars = new ArrayList<>();
        adapter = new DataKegiatanAdapter(listDataPasars,getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setEmptyView(textKosong);
        String tanggal = getArguments().getString("tanggal");
        String month = getArguments().getString("bulan");
        String [] dateParts = tanggal.split("-");
        bulan = dateParts[1];
        tahun = dateParts[0];
        keterangan.setText("Agenda Kegiatan Kota Pekalongan pada bulan "+month+" tahun "+tahun);
        api = ServiceGenerator.createService(ServiceApi.class);
        ambilData();
        recyclerView.setAdapter(adapter);
        return fragmentView;
    }

    private void ambilData(){
        final ProgressDialog dialog = Utils.getWaitDialog(getContext(),"Loading...");
        dialog.show();
        dialog.setCancelable(false);
        Call<Kegiatan> resultKegiatan = api.getKegiatan(bulan,tahun);

        resultKegiatan.enqueue(new Callback<Kegiatan>() {
            @Override
            public void onResponse(Call<Kegiatan> call, Response<Kegiatan> response) {
                Log.e(TAG,response.body().getData().get(0).getAcara());
                dialog.dismiss();
                listDataPasars.addAll(response.body().getData());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Kegiatan> call, Throwable t) {
                dialog.dismiss();
                Utils.toastLong(getContext(),"Mengambil Data Response Gagal, Pastikan Terkoneksi Internet! ");
                Log.e(TAG," Mengambil Data Response Gagal "+t.getMessage());
            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
