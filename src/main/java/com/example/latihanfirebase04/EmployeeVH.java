package com.example.latihanfirebase04;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeVH extends RecyclerView.ViewHolder
{
    public TextView txt_nama,txt_alamat,txt_nomorhp,txt_option;
    public EmployeeVH(@NonNull View itemView)
    {
        super(itemView);
        txt_nama = itemView.findViewById(R.id.txt_nama);
        txt_alamat = itemView.findViewById(R.id.txt_alamat);
        txt_nomorhp = itemView.findViewById(R.id.txt_nomorhp);
        txt_option = itemView.findViewById(R.id.txt_option);


    }
}
