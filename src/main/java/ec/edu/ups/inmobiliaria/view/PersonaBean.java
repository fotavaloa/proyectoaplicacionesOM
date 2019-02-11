package ec.edu.ups.inmobiliaria.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.bussiness.PersonaBussiness;
import ec.edu.ups.inmobiliaria.modelo.Persona;

@ManagedBean
@RequestScoped

public class PersonaBean {
	
	@Inject
	private PersonaBussiness personaBussiness;
	
	private Persona persona;
	
	private String correoL;
	private String passL;
	
	private List<Persona> personas;
	
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		persona = new Persona();
		personas=personaBussiness.listarp();
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public String getCorreoL() {
		return correoL;
	}

	public void setCorreoL(String correoL) {
		this.correoL = correoL;
	}

	public String getPassL() {
		return passL;
	}

	public void setPassL(String passL) {
		this.passL = passL;
	}
	

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public String login() {
		String redirect = "";
		if(personaBussiness.login(correoL, passL)) {
			redirect = "inmuebles.xhtml?faces-redirect=true";
		} else {
			redirect = "";
		}
		return redirect;
	}
	
	public String guardarPersona() {
		String redirect = "";
		if(personaBussiness.guardarPersona(persona)) {
			redirect = "login.xhtml?faces-redirect=true";
		} else {
			redirect = "";
		}
		return redirect;
	}
	
	public String logout() {
		System.out.println("------------------------------------------------>SALIR");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "login.xhtml?faces-redirect=true";
	}
	
	public String EliminarP(int id) {
		try {
		personaBussiness.eliminarP(id);
		System.out.println("registro eliminado");
		return"ListadoPersona.xhtml?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al eliminar");
			e.printStackTrace();
		}
		return null;
	}

}
