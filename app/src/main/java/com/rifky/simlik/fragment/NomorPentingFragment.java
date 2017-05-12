package com.rifky.simlik.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rifky.simlik.R;
import com.rifky.simlik.adapter.NomorPentingAdapter;
import com.rifky.simlik.model.NomorPenting;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by rifky on 07/05/17.
 */

public class NomorPentingFragment extends Fragment {
    @BindView(R.id.rv_nomor_penting)
    RecyclerView recyclerViewNomor;
    private Unbinder unbinder;
    private NomorPentingAdapter adapter;
    private List<NomorPenting> listNomorPentings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_nomor_penting,container,false);
        unbinder = ButterKnife.bind(NomorPentingFragment.this, fragmentView);
        listNomorPentings = ambilData();
        adapter = new NomorPentingAdapter(listNomorPentings,getContext());
        recyclerViewNomor.setHasFixedSize(true);
        recyclerViewNomor.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewNomor.setAdapter(adapter);
        return fragmentView;
    }

    private List <NomorPenting> ambilData(){
        List<NomorPenting> data = new ArrayList<>();
        data.add(new NomorPenting("RSUD Bendan","0285437222"));
        data.add(new NomorPenting("RSUD Kraton","0285420118"));
        data.add(new NomorPenting("RS Budi Rahayu","0285423491"));
        data.add(new NomorPenting("RS Siti Khotijah","0285422845"));
        data.add(new NomorPenting("Pemadam Kebakaran","0285435301"));
        data.add(new NomorPenting("PMI Pekalongan","0285421580"));
        data.add(new NomorPenting("PLN Pekalongan","0285434785"));
        data.add(new NomorPenting("Stasiun KA","0285421161"));
        data.add(new NomorPenting("PDAM Pekalongan","0285421558"));
        data.add(new NomorPenting("Pegadaian","0285423629"));
        data.add(new NomorPenting("Plasa Telkom Pekalongan","0285427072"));
        data.add(new NomorPenting("KPP Pratama","0285422491"));
        data.add(new NomorPenting("Taxi","02857900507"));
        data.add(new NomorPenting("Pandu Siwi Sentosa","0285429241"));
        data.add(new NomorPenting("TIKI","0285423316"));
        data.add(new NomorPenting("JNE","02857903440"));
        data.add(new NomorPenting("Hotel Pekalongan","0285421021"));
        data.add(new NomorPenting("Hotel Hayam Wuruk","0285422823"));
        data.add(new NomorPenting("Hotel Indonesia","0285422732"));
        data.add(new NomorPenting("Hotel Nirwana","0285392100"));
        data.add(new NomorPenting("Hotel Syariah","0285422446"));
        data.add(new NomorPenting("Travel Dragon","0285432244"));
        data.add(new NomorPenting("Travel Nusantara","0285431636"));
        data.add(new NomorPenting("Travel Mutiara","0285420288"));
        data.add(new NomorPenting("Travel Persada","02854416277"));
        data.add(new NomorPenting("Unit Laka Lantas Polres Pekalongan Kota","0285433228"));
        data.add(new NomorPenting("Polres Pekalongan Utara","0285421692"));
        data.add(new NomorPenting("Polres Pekalongan Barat","0285422321"));
        data.add(new NomorPenting("Polsek Buaran","0285422958"));
        data.add(new NomorPenting("Polsek Pekalongan Selatan ","0285432429"));
        data.add(new NomorPenting("Polsek Tirto","0285422047"));
        data.add(new NomorPenting("Polsek Pekalongan Utara","0285422669"));
        data.add(new NomorPenting("Polsek Pekalongan Timur","0285421031"));
        data.add(new NomorPenting("Satlantas Pekalongan Kota","0285422141"));
        data.add(new NomorPenting("Siaga Satreskrim Pekalongan Kota","085747528686"));
        data.add(new NomorPenting("Pos Lantas Grogolan","0285422838"));
        data.add(new NomorPenting("Pos Lantas THR","0285434585"));
        data.add(new NomorPenting("Panggilan Darurat","112"));
        data.add(new NomorPenting("Ambulan","118"));
        data.add(new NomorPenting("Pemadam Kebakaran","113"));
        data.add(new NomorPenting("Polisi","110"));
        data.add(new NomorPenting("SAR","115"));
        data.add(new NomorPenting("Posko Bencana Alam","129"));
        data.add(new NomorPenting("Palang Merah Indonesia","0214207051"));
        data.add(new NomorPenting("PMI Unit Tranfusi Darah","3906666"));
        data.add(new NomorPenting("Centra Informasi Keracunan","0214250767"));
        data.add(new NomorPenting("Pencegahan bunuh diri","0217256526"));
        data.add(new NomorPenting("Konseling masalah kejiwaan","500454"));
        data.add(new NomorPenting("Call Center Telkom","147"));
        data.add(new NomorPenting("Call Center PLN","123"));
        data.add(new NomorPenting("Pengaduan Gangguan Telepon","117"));
        data.add(new NomorPenting("Call Center Bank Mandiri","14000"));
        data.add(new NomorPenting("Call Center Bank BNI","1500046"));
        data.add(new NomorPenting("Call Center Bank BRI","14017"));
        data.add(new NomorPenting("Call Center Bank BCA","1500888"));
        data.add(new NomorPenting("Call Center Bank Jateng","14066"));

        return data;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
