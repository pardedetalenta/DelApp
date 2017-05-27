package org.del.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.del.dao.FasilitasDao;
import org.del.models.Fasilitas;
import org.del.models.Kegiatan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FasilitasDaoImpl implements FasilitasDao {

	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	@Override
	public List<Fasilitas> listFasilitas() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Fasilitas", Fasilitas.class).getResultList();
	}

	@Override
	public Fasilitas tambah(Fasilitas fasilitas) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Fasilitas saved = em.merge(fasilitas);
		em.getTransaction().commit();
			return saved;
	}

}
