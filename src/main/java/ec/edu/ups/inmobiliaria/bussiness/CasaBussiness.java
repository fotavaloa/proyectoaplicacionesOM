package ec.edu.ups.inmobiliaria.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.dao.CasaDao;
import ec.edu.ups.inmobiliaria.dao.InmuebleDao;
import ec.edu.ups.inmobiliaria.modelo.Casa;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@Stateless
public class CasaBussiness {
	
	@Inject
	private CasaDao casaDao;
	
	@Inject
	private InmuebleDao inmuebleDao;
	//lee los datos  del inmueble
	public Inmueble buscarInmueble(int id) {
		Inmueble inmueble = inmuebleDao.buscarInmueble(id);
		return inmueble;
	}
	//funcion para  el registro del tipo de inmueble    con su respectivo id 
	public boolean guardarCasa(Casa casa, Inmueble inmueble) {
		boolean estado = false; //devuelve un estado
		
		Casa ca = casaDao.buscarCasa(casa.getId());
		if (ca== null) {
			//inserta la casa y el inmueble  
			casa.setTitulo("Casa");
			casa.setInmuebleCasa(inmueble);
			casaDao.insertarCasa(casa);
			estado = true;
			
		}else {
			estado=false;
		}
		return estado;
	}
	
	

}
