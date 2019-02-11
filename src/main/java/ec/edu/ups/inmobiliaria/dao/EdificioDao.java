package ec.edu.ups.inmobiliaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Edificio;


@Stateless
public class EdificioDao {
	
	@Inject
	private EntityManager em;
	//matenimito grud  
	public void insertarEdificio(Edificio edificio) {
		em.persist(edificio);
	}
	
	public void actualizarEdificio(Edificio edificio) {
		em.merge(edificio);
	}
	
	public void eliminarEdificio (int id) {
		Edificio edificio=em.find(Edificio.class, id);
		em.remove(edificio);
	}
	
	public Edificio buscarEdificio (int id) {
		Edificio edificio = em.find(Edificio.class, id);
		return edificio;
	}
	
	public void guardarEdificio(Edificio edificio) {
		Edificio e = buscarEdificio(edificio.getId());
		if (e==null) {
			insertarEdificio(edificio);			
		}else {
			actualizarEdificio(edificio);
		}
	}
	//creaciondel listado
	@SuppressWarnings("unchecked")
	public List<Edificio> ListarCasas(int id){
		String jpql = "SELECT e FROM Edificio e";
		Query query = em.createQuery(jpql, Edificio.class);
		List<Edificio> lcasas= query.getResultList();		
		return lcasas;
	}


}
