package ec.edu.ups.inmobiliaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Terreno;

@Stateless
public class TerrenoDao {
	
	@Inject
	private EntityManager em;
	
//Mantenimiento grud
	public void insertarTerreno (Terreno terreno) {
		em.persist(terreno);
	}
	
	public void actualizarTerreno (Terreno terreno) {
		em.merge(terreno);
	}
	
	public void eliminarTerreno (int id) {
		Terreno terreno =em.find(Terreno.class, id);
		em.remove(terreno);
	}
	
	public Terreno buscarTerreno (int id) {
		Terreno terreno = em.find(Terreno.class, id);
		return terreno;
	}
	
	public void guardarTerreno (Terreno terreno) {
		Terreno t = buscarTerreno(terreno.getId());
		if (t==null) {
			insertarTerreno(terreno);			
		}else {
			actualizarTerreno (terreno);
		}
	}
	//listado de  todos los terreno  con su respectipo id
	@SuppressWarnings("unchecked")
	public List<Terreno> ListarTerrenos(int id){
		String jpql = "SELECT t FROM Terreno t";
		Query query = em.createQuery(jpql, Terreno.class);
		List<Terreno> lterrenos= query.getResultList();		
		return lterrenos;
	}


}
