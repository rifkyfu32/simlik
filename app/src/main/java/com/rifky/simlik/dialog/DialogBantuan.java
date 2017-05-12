package com.rifky.simlik.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.rifky.simlik.R;

/**
 * Created by rifky on 07/05/17.
 */

public class DialogBantuan extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        View view = LayoutInflater.from(DialogBantuan.this.getActivity()).inflate(R.layout.bantuan, null, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogBantuan.this.getActivity());
        builder.setView(view);
        builder.setNegativeButton(R.string.tomboldialog_tutup, mOnClickListener);

        return builder.create();
    }


    DialogInterface.OnClickListener mOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            DialogBantuan.this.getDialog().dismiss();

        }
    };

}