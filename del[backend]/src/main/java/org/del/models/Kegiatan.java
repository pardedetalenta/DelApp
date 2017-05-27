package org.del.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="kegiatan")
public class Kegiatan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Integer id; 
	@Column (name = "nama_kegiatan")
	private String  nama_kegiatan;
	@Column (name = "gambar_kegiatan")
	private String  gambar_kegiatan;
	@Column (name = "keterangan")
	private String  keterangan;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama_kegiatan() {
		return nama_kegiatan;
	}
	public void setNama_kegiatan(String nama_kegiatan) {
		this.nama_kegiatan = nama_kegiatan;
	}
	public String getGambar_kegiatan() {
		return gambar_kegiatan;
	}
	public void setGambar_kegiatan(String gambar_kegiatan) {
		this.gambar_kegiatan = gambar_kegiatan;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
	
	