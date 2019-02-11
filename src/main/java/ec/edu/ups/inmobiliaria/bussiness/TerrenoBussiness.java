package ec.edu.ups.inmobiliaria.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.dao.InmuebleDao;
import ec.edu.ups.inmobiliaria.dao.TerrenoDao;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;
import ec.edu.ups.inmobiliaria.modelo.Terreno;

@Stateless
public class TerrenoBussiness {

	@Inject
	private TerrenoDao terrenoDao;
	
	@Inject
	private InmuebleDao inmuebleDao;
	
	public Inmueble buscarInmueble(int id) {
		Inmueble inmueble = inmuebleDao.buscarInmueble(id);
		return inmueble;
	}
	//registro del tipo  de inmuble  con su respectivo id  devolviendo un estado de  true o false
	public boolean guardarTerreno(Terreno terreno, Inmueble inmueble) {
		boolean estado = false;
		
		Terreno ter = terrenoDao.buscarTerreno(terreno.getId());
		if (ter== null) {
			
			terreno.setTitulo("Terreno");
			terreno.setInmuebleTerreno(inmueble);
			terrenoDao.insertarTerreno(terreno);
			estado = true;
			
		}else {
			estado=false;
		}
		return estado;
	}
}
