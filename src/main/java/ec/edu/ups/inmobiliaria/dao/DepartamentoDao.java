package ec.edu.ups.inmobiliaria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.inmobiliaria.modelo.Departamento;


@Stateless
public class DepartamentoDao {

	//una inyection  de la entidad administradora
	@Inject
	private EntityManager em;
	//matenimietno
	public void insertarDepartamento(Departamento departamento) {
		em.persist(departamento);
	}
	
	public void actualizarDepartamento(Departamento departamento) {
		em.merge(departamento);
	}
	
	public void eliminarDepartamento (int id) {
		Departamento departamento=em.find(Departamento.class, id);
		em.remove(departamento);
	}
	
	public Departamento buscarDepartamento (int id) {
		Departamento departamento = em.find(Departamento.class, id);
		return departamento;
	}
	
	public void guardarCasa(Departamento departamento) {
		Departamento d = buscarDepartamento(departamento.getId());
		if (d==null) {
			insertarDepartamento(departamento);			
		}else {
			actualizarDepartamento(departamento);
		}
	}
	//listado de todas
	@SuppressWarnings("unchecked")
	public List<Departamento> ListarDepartamentos(int id){
		String jpql = "SELECT d FROM Departamento d";
		Query query = em.createQuery(jpql, Departamento.class);
		List<Departamento> ldepartamentos= query.getResultList();		
		return ldepartamentos;
	}

	
}
