package com.rifky.simlik.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.rifky.simlik.R;
import com.rifky.simlik.helper.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by rifky on 07/05/17.
 */

public class KegiatanFragment extends Fragment {
    @BindView(R.id.input_tanggal)
    EditText etTanggal;
    @BindView(R.id.btn_cek)
    Button btnCek;
    private DatePickerDialog datePicker;
    private SimpleDateFormat dateFormatter;
    private SimpleDateFormat month_date;
    private Calendar calendar;
    private Unbinder unbinder;
    private String bulan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(KegiatanFragment.this.getActivity()).inflate(R.layout.fragment_kegiatan, container, false);
        unbinder = ButterKnife.bind(KegiatanFragment.this, view);

        setDateTimeField();
        etTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard();
                datePicker.show();
            }
        });
        btnCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (requiredField(etTanggal)) return;

                FragmentTransaction ft =
                        KegiatanFragment.this.getActivity()
                                .getSupportFragmentManager()
                                .beginTransaction();
                Bundle dataBundle = new Bundle();
                dataBundle.putString("tanggal", etTanggal.getText().toString());
                dataBundle.putString("bulan", bulan);
                DataKegiatanFragment dataKegiatanFragment = new DataKegiatanFragment();
                dataKegiatanFragment.setArguments(dataBundle);
                ft.replace(R.id.fragment_halaman_utama, dataKegiatanFragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return view;
    }

    private void setDateTimeField() {
        calendar = Calendar.getInstance();
        datePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);
                dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                etTanggal.setText(dateFormatter.format(calendar.getTime()));
                month_date = new SimpleDateFormat("MMMM", new Locale("id"));
                bulan = month_date.format(calendar.getTime());
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

    }

    private void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(etTanggal.getWindowToken(), 0);
    }

    private boolean requiredField(EditText editText) {
        if (TextUtils.isEmpty(editText.getText())) {
            editText.setError("Wajib di isi");
            editText.setFocusable(true);
            Utils.toastLong(getContext(), "Tanggal tidak boleh kosong");

            return true;
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
