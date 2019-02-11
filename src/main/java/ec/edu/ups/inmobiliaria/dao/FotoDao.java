package ec.edu.ups.inmobiliaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Foto;

@Stateless
public class FotoDao {
//inyecion  de la tabla administradora
	@Inject
	private EntityManager em;
	
//mantenimiento grud
	public void insertarFoto(Foto foto) {
		em.persist(foto);
	}
	
	public void actualizarFoto(Foto foto) {
		em.merge(foto);
	}
	
	public void eliminarFoto (int id) {
		Foto foto=em.find(Foto.class, id);
		em.remove(foto);
	}
	
	public Foto buscarFoto (int id) {
		Foto foto = em.find(Foto.class, id);
		return foto;
	}
	
	public void guardarFoto(Foto foto) {
		Foto f = buscarFoto(foto.getId());
		if (f==null) {
			insertarFoto(foto);			
		}else {
			actualizarFoto(foto);
		}
	}
	///listado de  fotos
	@SuppressWarnings("unchecked")
	public List<Foto> ListarFotos(int id){
		String jpql = "SELECT f FROM Foto f";
		Query query = em.createQuery(jpql, Foto.class);
		List<Foto> lfotos= query.getResultList();		
		return lfotos;
	}

}
