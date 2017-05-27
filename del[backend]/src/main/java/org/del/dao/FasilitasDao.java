package org.del.dao;

import java.util.List;

import org.del.models.Fasilitas;


public interface FasilitasDao {
List <Fasilitas> listFasilitas();
	
	public Fasilitas tambah (Fasilitas fasilitas);

}
