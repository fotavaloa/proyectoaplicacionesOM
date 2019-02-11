package ec.edu.ups.inmobiliaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Casa;

@Stateless
public class CasaDao {
	
	@Inject
	private EntityManager em;
	//metodo grud para  realizar el mantenimiento
	public void insertarCasa(Casa casa) {
		em.persist(casa);
	}
	
	public void actualizarCasa(Casa casa) {
		em.merge(casa);
	}
	
	public void eliminarCasa (int id) {
		Casa casa=em.find(Casa.class, id);
		em.remove(casa);
	}
	
	public Casa buscarCasa (int id) {
		Casa casa = em.find(Casa.class, id);
		return casa;
	}
	
	public void guardarCasa(Casa casa) {
		Casa c = buscarCasa(casa.getId());
		if (c==null) {
			insertarCasa(casa);			
		}else {
			actualizarCasa(casa);
		}
	}
	///creacion de la lista de casas
	@SuppressWarnings("unchecked")
	public List<Casa> ListarCasas(int id){
		String jpql = "SELECT c FROM Casa c";
		Query query = em.createQuery(jpql, Casa.class);
		List<Casa> lcasas= query.getResultList();		
		return lcasas;
	}

}
