package Dao;

import java.io.Serializable;
import java.util.List;

import Modelo.Inmueble;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class InmuebleDAO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Inmueble inmueble) {
		em.persist(inmueble);
	}
	
	public void update(Inmueble inmueble) {
		em.merge(inmueble);
	}
	
	public Inmueble read(int codigo) {
		Inmueble i = em.find(Inmueble.class, codigo);
		return i;
	}
	
	public void delete(int codigo) {
		Inmueble i = em.find(Inmueble.class, codigo);
		em.remove(i);
	}
	
	public List<Inmueble> getAll(){
		String jpql = "SELECT i FROM Inmueble i";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
