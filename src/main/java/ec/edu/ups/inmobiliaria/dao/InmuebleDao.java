package ec.edu.ups.inmobiliaria.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@Stateless
public class InmuebleDao {
	//inyectamos la entidad adminitradora
	@Inject
	private EntityManager em;
	
//metodo grud
	public void insertarInmueble (Inmueble inmueble) {
		em.persist(inmueble);
	}
	
	public void actualizarInmueble(Inmueble inmueble) {
		em.merge(inmueble);
	}
	
	public void eliminarInmueble (int id) {
		Inmueble inmueble=em.find(Inmueble.class, id);
		em.remove(inmueble);
	}
	
	public Inmueble buscarInmueble (int id) {
		Inmueble inmueble = em.find(Inmueble.class, id);
		return inmueble;
	}
	
	public void guardarInmueble (Inmueble inmueble) {
		Inmueble i = buscarInmueble(inmueble.getId());
		if (i==null) {
			Date currenDate = new Date();
			inmueble.setFechapublicacion(currenDate);
			insertarInmueble (inmueble);			
		}else {
			actualizarInmueble(inmueble);
		}
	}
	//funcion 1  listar los inmuebes  por  fecha en forma decendente
	@SuppressWarnings("unchecked")
	public List<Inmueble> ListarInmuebles(){
		String jpql = "SELECT i FROM Inmueble i ORDER BY inmfechapublicacion DESC";
		Query query = em.createQuery(jpql, Inmueble.class);
		List<Inmueble> linmuebles= query.getResultList();		
		return linmuebles;
	}
	//funcion2 listar los inmubles por precion de inmuebles  
	@SuppressWarnings("unchecked")
	public List<Inmueble> ListarInmueblePrecio(){
		String jpql = "SELECT i FROM Inmueble i ORDER BY inmprecio DESC";
		Query query = em.createQuery(jpql, Inmueble.class);
		List<Inmueble> linmuebles= query.getResultList();		
		return linmuebles;
	}
	
	//funcion3 listar los inmuebles por el numero distas
	
	@SuppressWarnings("unchecked")
	public List<Inmueble> ListarInmuebleVisitas(){
		String jpql = "SELECT i FROM Inmueble i ORDER BY inmvisitas DESC";
		Query query = em.createQuery(jpql, Inmueble.class);
		List<Inmueble> linmuebles= query.getResultList();		
		return linmuebles;
	}


}
