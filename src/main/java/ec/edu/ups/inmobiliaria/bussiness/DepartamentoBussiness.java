package ec.edu.ups.inmobiliaria.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.dao.DepartamentoDao;
import ec.edu.ups.inmobiliaria.dao.InmuebleDao;
import ec.edu.ups.inmobiliaria.modelo.Departamento;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@Stateless
public class DepartamentoBussiness {
	
	@Inject
	private DepartamentoDao departamentoDao;
	
	@Inject
	private InmuebleDao inmuebleDao;
	
	public Inmueble buscarInmueble(int id) {
		Inmueble inmueble = inmuebleDao.buscarInmueble(id);
		return inmueble;
		
	}
	//funcion para el registro  del departametno con su respectibo id
	public boolean guardarDepartamento(Departamento departamento, Inmueble inmueble ) {
		
		boolean estado= false;
		Departamento dep = departamentoDao.buscarDepartamento(departamento.getId());
		if (dep==null) {
			
			//inserta el departamento  con  su respetvio inmueble
			departamento.setTitulo("Departamento");
			departamento.setInmuebleDepartamento(inmueble);
			departamentoDao.insertarDepartamento(departamento);
			estado=true;
			
		}else {
			estado=false;
		}
		return estado;//devuelve el estado  del registro guardado
	}

}
