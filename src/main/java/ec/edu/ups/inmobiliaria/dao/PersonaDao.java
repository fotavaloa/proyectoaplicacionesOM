package ec.edu.ups.inmobiliaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Persona;
 


@Stateless
public class PersonaDao {
	//inyectamos la entidad administradora
	@Inject
	private EntityManager em;
	
//mantenimietno grud
	public void insertarPersona (Persona persona) {
		em.persist(persona);
	}
	
	public void actualizarPersona (Persona persona) {
		em.merge(persona);
	}
	
	public void eliminarPersona (int id) {
		//Persona persona=em.find(Persona.class, id);
		em.remove(this.buscarPersona(id));
	}
	
	public Persona buscarPersona (int id) {
		Persona persona = em.find(Persona.class, id);
		return persona;
	}
	
	public void guardarPersona(Persona persona) {
		Persona p = buscarPersona(persona.getId());
		if (p==null) {
			insertarPersona(persona);			
		}else {
			actualizarPersona(persona);
		}
	}
	
	//funcion 4 listado de las personas
	@SuppressWarnings("unchecked")
	public List<Persona> ListarPersonas(int id){
		String jpql = "SELECT p FROM Persona p";
		Query query = em.createQuery(jpql, Persona.class);
		List<Persona> lpersonas= query.getResultList();		
		return lpersonas;
	}
	@SuppressWarnings("unchecked")
	public List<Persona> getListarPersonas(){
		String jpql = "SELECT p FROM Persona p";
		Query query = em.createQuery(jpql, Persona.class);
		List<Persona> listado = query.getResultList();		
		return listado;
	}
	//funcion 5 consulta del  correo y la contrasenia para la autentificacion
	public Persona loginUsuario(String correo, String passwd) {
		String jpql = "SELECT p FROM Persona p " + "WHERE percorreo = ? " + "AND perpass = ? ";

		Query query = em.createQuery(jpql, Persona.class);
		query.setParameter(1, correo);
		query.setParameter(2, passwd);

		try {
			Persona persona = (Persona) query.getSingleResult();
			return persona;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
