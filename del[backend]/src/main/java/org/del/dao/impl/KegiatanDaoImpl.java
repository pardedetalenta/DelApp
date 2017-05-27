package org.del.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.del.dao.KegiatanDao;
import org.del.models.Kegiatan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KegiatanDaoImpl implements KegiatanDao{

	private EntityManagerFactory emf;

	@Autowired
	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	@Override
	public List<Kegiatan> listKegiatan() {
		EntityManager em = emf.createEntityManager();
		return em.createQuery("from Kegiatan", Kegiatan.class).getResultList();
		
	}
	@Override
	public Kegiatan tambah(Kegiatan kegiatan) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Kegiatan saved = em.merge(kegiatan);
		em.getTransaction().commit();
			return saved;
	}

}
