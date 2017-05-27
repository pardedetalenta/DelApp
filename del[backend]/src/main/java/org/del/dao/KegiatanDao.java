package org.del.dao;

import java.util.List;

import org.del.models.Kegiatan;

public interface KegiatanDao {
	
	List <Kegiatan> listKegiatan();
	
	public Kegiatan tambah (Kegiatan kegiatan);

}
