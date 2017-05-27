package com.example.talenta.delappproject;

/**
 * Created by Talenta on 5/21/2017.
 */

public class ModelKegiatan {
    private int id;
    private String nama_kegiatan;
    private String gambar_kegiatan;
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

    public String getGambar_kegiatan() {
        return gambar_kegiatan;
    }

    public void setGambar_kegiatan(String gambar_kegiatan) {
        this.gambar_kegiatan = gambar_kegiatan;
    }

    public String getNama_kegiatan() {
        return nama_kegiatan;
    }

    public void setNama_kegiatan(String nama_kegiatan) {
        this.nama_kegiatan = nama_kegiatan;
    }

}
