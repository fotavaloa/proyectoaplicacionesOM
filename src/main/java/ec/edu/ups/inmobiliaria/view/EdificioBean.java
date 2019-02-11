package ec.edu.ups.inmobiliaria.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.bussiness.EdificioBussiness;
import ec.edu.ups.inmobiliaria.modelo.Edificio;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@ManagedBean
@RequestScoped
public class EdificioBean {
	

	@Inject
	private EdificioBussiness edificioBussiness;
	
	private Edificio edificio;
	
	private Inmueble inmueble;
	
	private int idInsert;
	
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		edificio = new Edificio();
		inmueble = new Inmueble();
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	public int getIdInsert() {
		return idInsert;
	}

	public void setIdInsert(int idInsert) {
		this.idInsert = idInsert;
	}
	//registrando  el  el edificon  traendo el id de inmbueble
	
	public String guardarEdificio() {
		buscarInmueble();
		String redirect = "";
		if(edificioBussiness.guardarEdificio(edificio, inmueble)) {
			redirect = "inmuebles.xhtml?faces-redirect=true";
		} else {
			redirect = "";
		}
		return redirect;
	}
	
	public void buscarInmueble() {
		inmueble = edificioBussiness.buscarInmueble(idInsert);
	}


}
