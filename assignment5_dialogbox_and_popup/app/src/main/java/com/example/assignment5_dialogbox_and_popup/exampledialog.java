package com.example.assignment5_dialogbox_and_popup;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class exampledialog extends AppCompatDialogFragment {
    EditText Name,password;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflate=getActivity().getLayoutInflater();
        View view=layoutInflate.inflate(R.layout.example_dialog,null);
        Name=view.findViewById(R.id.editTextTextPersonName);
        password=view.findViewById(R.id.editTextTextPersonName2);

        builder.setView(view)
                .setTitle("registrtion")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Register", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(,"clicked on register",Toast.LENGTH_LONG).show();
                    }
                });
        return builder.create();


    }
}
