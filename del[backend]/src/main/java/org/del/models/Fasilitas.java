package org.del.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="fasilitas")
public class Fasilitas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "id")
	private Integer id; 
	@Column (name = "nama_fasilitas")
	private String  nama_fasilitas;
	@Column (name = "gambar_fasilitas")
	private String  gambar_fasilitas;
	@Column (name = "keterangan")
	private String  keterangan;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama_fasilitas() {
		return nama_fasilitas;
	}
	public void setNama_fasilitas(String nama_fasilitas) {
		this.nama_fasilitas = nama_fasilitas;
	}
	public String getGambar_fasilitas() {
		return gambar_fasilitas;
	}
	public void setGambar_fasilitas(String gambar_fasilitas) {
		this.gambar_fasilitas = gambar_fasilitas;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
}
