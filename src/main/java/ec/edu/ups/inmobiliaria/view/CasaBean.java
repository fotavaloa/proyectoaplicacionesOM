package ec.edu.ups.inmobiliaria.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.bussiness.CasaBussiness;
import ec.edu.ups.inmobiliaria.modelo.Casa;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@ManagedBean
@RequestScoped
public class CasaBean {
	
	@Inject
	private CasaBussiness casaBussiness;
	
	private Casa casa;
	
	private Inmueble inmueble;
	
	private int idInsert;
	
	@PostConstruct
	private void init() {
		casa = new Casa();
		inmueble = new Inmueble();
	}

	public Casa getCasa() {
		return casa;
	}

	public void setCasa(Casa casa) {
		this.casa = casa;
	}	
	
	public int getIdInsert() {
		return idInsert;
	}

	public void setIdInsert(int idInsert) {
		this.idInsert = idInsert;
	}
//guardar  el registro de cada  con su respectivo id  
	public String guardarCasa() {
		buscarInmueble();
		String redirect = "";
		if(casaBussiness.guardarCasa(casa, inmueble)) {
			redirect = "inmuebles.xhtml?faces-redirect=true";
		} else {
			redirect = "";
		}
		return redirect;
	}
	
	public void buscarInmueble() {
		inmueble = casaBussiness.buscarInmueble(idInsert);
	}
	

}
