package ec.edu.ups.inmobiliaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Oferta;

@Stateless
public class OfertaDao {
//inyectando la entidad administradora
	@Inject
	private EntityManager em;
	
//mantenimiento grup
	public void insertarOferta (Oferta oferta) {
		em.persist(oferta);
	}
	
	public void actualizarOferta (Oferta oferta) {
		em.merge(oferta);
	}
	
	public void eliminarOferta (int id) {
		Oferta oferta=em.find(Oferta.class, id);
		em.remove(oferta);
	}
	
	public Oferta buscarOferta (int id) {
		Oferta oferta = em.find(Oferta.class, id);
		return oferta;
	}
	
	public void guardarOferta (Oferta oferta) {
		Oferta o = buscarOferta (oferta.getId());
		if (o==null) {
			insertarOferta (oferta);			
		}else {
			actualizarOferta (oferta);
		}
	}
	//listado de la oferta
	@SuppressWarnings("unchecked")
	public List<Oferta> ListarOfertas(int id){
		String jpql = "SELECT o FROM Oferta o";
		Query query = em.createQuery(jpql, Oferta.class);
		List<Oferta> lofertas= query.getResultList();		
		return lofertas;
	}

}
