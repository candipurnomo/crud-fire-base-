package com.example.latihanfirebase04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edit_nama = findViewById(R.id.edit_nama);
        final EditText edit_alamat = findViewById(R.id.edit_alamat);
        final EditText edit_nomorhp = findViewById(R.id.edit_nomorhp);
        Button btn = findViewById(R.id.btn_submit);
        Button btn_open = findViewById(R.id.btn_open);
        btn_open.setOnClickListener(v ->
        {
            Intent intent =new Intent(MainActivity.this,RVActivity.class);
            startActivity(intent);

        });
        DAOEmployee doa =new DAOEmployee();
        Employee emp_edit = (Employee) getIntent().getSerializableExtra("EDIT");
        if (emp_edit !=null)
        {
            btn.setText("UPDATE");
            edit_nama.setText(emp_edit.getNama());
            edit_alamat.setText(emp_edit.getAlamat());
            edit_nomorhp.setText(emp_edit.getNomorhp());
            btn_open.setVisibility(View.GONE);
        }
        else
            {
                btn.setText("SUBMIT");
                btn_open.setVisibility(View.VISIBLE);
            }
        btn.setOnClickListener(v -> {
             //input data
            Employee emp = new Employee(edit_nama.getText().toString(),edit_alamat.getText().toString(),edit_nomorhp.getText().toString());
            if (emp_edit==null)
            {
                doa.add(emp).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
            else
                {
                    HashMap<String,Object> hashMap = new HashMap<>();
                    hashMap.put("nama",edit_nama.getText().toString());
                    hashMap.put("alamat",edit_alamat.getText().toString());
                    hashMap.put("nomorhp",edit_nomorhp.getText().toString());
                    doa.update(emp_edit.getKey(),hashMap).addOnSuccessListener(suc->
                    {
                        Toast.makeText(this, "Record is update", Toast.LENGTH_SHORT).show();
                        finish();
                    }).addOnFailureListener(er->
                    {
                        Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                    });

                }

            //update
            /*HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("nama",edit_nama.getText().toString());
            hashMap.put("alamat",edit_alamat.getText().toString());
            hashMap.put("nomorhp",edit_nomorhp.getText().toString());
            Employee emp = new Employee(edit_nama.getText().toString(),edit_alamat.getText().toString(),edit_nomorhp.getText().toString());
            doa.update("-Mq9WeRXRnPRY_yRE668",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record is update", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });*/

            //romove
            /*doa.romove("-Mq9WeRXRnPRY_yRE668").addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record is romoved", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });*/


        });

    }
}