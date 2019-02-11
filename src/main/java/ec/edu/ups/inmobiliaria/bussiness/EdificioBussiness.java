package ec.edu.ups.inmobiliaria.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.dao.EdificioDao;
import ec.edu.ups.inmobiliaria.dao.InmuebleDao;
import ec.edu.ups.inmobiliaria.modelo.Edificio;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@Stateless
public class EdificioBussiness {
	//inyecta  los  el dao del los edificios  y  de los inmuebles
	@Inject
	private EdificioDao edificioDao;
	
	@Inject
	private InmuebleDao inmuebleDao;
	//lee el inmuebles  con su respectibo id
	public Inmueble buscarInmueble(int id) {
		Inmueble inmueble = inmuebleDao.buscarInmueble(id);
		return inmueble;
	}
	// registra los campos del registro con su respectivo inmueble
	public boolean guardarEdificio(Edificio edificio, Inmueble inmueble) {
		boolean estado = false;
		
		Edificio edi = edificioDao.buscarEdificio(edificio.getId());
		if (edi== null) {
			
			edificio.setTitulo("Edificio");
			edificio.setInmuebleEdificio(inmueble);
			edificioDao.insertarEdificio(edificio);
			estado = true;
			
		}else {
			estado=false;
		}
		return estado;
	}

}
