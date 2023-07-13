package Dao;

import java.io.Serializable;
import java.util.List;

import Modelo.Persona;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
public class PersonaDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona read(int codigo) {
		Persona p = em.find(Persona.class, codigo);
		return p;
	}
	
	public void delete(int codigo) {
		Persona p = em.find(Persona.class, codigo);
		em.remove(p);
	}
	
	public List<Persona> getAll(){
		String jpql = "SELECT p FROM Persona p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}
