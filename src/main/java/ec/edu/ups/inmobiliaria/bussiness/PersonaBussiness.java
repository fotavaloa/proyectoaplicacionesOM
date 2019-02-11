package ec.edu.ups.inmobiliaria.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.dao.PersonaDao;
import ec.edu.ups.inmobiliaria.modelo.Persona;

@Stateless
public class PersonaBussiness {

	@Inject
	private PersonaDao personaDao;
	//registra la persona
	public boolean guardarPersona (Persona persona) {
		boolean estado=false;
		Persona per = personaDao.buscarPersona(persona.getId());
		if (per==null) {
			personaDao.insertarPersona(persona);
			estado=true;
						
		}else {
			estado=false;
			
		}
		return estado;
	}
	
	
	//consulta en la base el logeo 
	public boolean login(String correoL, String passL) {
		boolean estado=false;
		try {
			Persona persona = personaDao.loginUsuario(correoL, passL);
			FacesContext context = FacesContext.getCurrentInstance();
			
			if (persona == null) {
				context.addMessage(null, new FacesMessage("--Error en el login, intente de nuevo"));
				correoL= null;
				passL=null;
				estado = false;
			}else {
				context.getExternalContext().getSessionMap().put("persona", persona);
				estado=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return estado;
	}
	
	
	//logeo para el webserice
	public boolean loginWS(String correoL, String passL) {
		boolean estado=false;
		try {
			Persona persona = personaDao.loginUsuario(correoL, passL);
			if (persona == null) {
				
				correoL= null;
				passL=null;
				estado = false;
			}else {
				
				estado=true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return estado;
	}
	
	//listar las personas
	public List<Persona> listarp(){
		return personaDao.getListarPersonas();
	}
	//eliminar  el  la persona   deseada
	public void eliminarP(int id)throws Exception{
		Persona pers=personaDao.buscarPersona(id);
		if(pers==null)
			throw new Exception("persona no existe");
		else
			
		personaDao.eliminarPersona(id);
	}
	
}
