package com.example.latihanfirebase04;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Employee implements Serializable
{
    @Exclude
    private  String key;
    private  String nama;
    private  String alamat;
    private  String nomorhp;

    public Employee(){}
    public Employee(String nama, String alamat, String nomorhp)
    {
        this.nama = nama;
        this.alamat = alamat;
        this.nomorhp = nomorhp;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomorhp() {
        return nomorhp;
    }

    public void setNomorhp(String nomorhp) {
        this.nomorhp = nomorhp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
