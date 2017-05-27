package com.example.talenta.delappproject;

/**
 * Created by Talenta on 5/23/2017.
 */

public class ModelFasilitas {
    private int id;
    private String nama_fasilitas;
    private String gambar_fasilitas;
    private String keterangan;

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGambar_fasilitas() {
        return gambar_fasilitas;
    }

    public void setGambar_fasilitas(String gambar_fasilitas) {
        this.gambar_fasilitas = gambar_fasilitas;
    }

    public String getNama_fasilitas() {
        return nama_fasilitas;
    }

    public void setNama_fasilitas(String nama_fasilitas) {
        this.nama_fasilitas = nama_fasilitas;
    }
}
