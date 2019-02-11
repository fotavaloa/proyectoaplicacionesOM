package ec.edu.ups.inmobiliaria.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.bussiness.TerrenoBussiness;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;
import ec.edu.ups.inmobiliaria.modelo.Terreno;
@ManagedBean
@RequestScoped
public class TerrenoBean {
	
	@Inject
	private TerrenoBussiness terrenoBussines;
	
	private Terreno terreno;
	
	private Inmueble inmueble;
	
	private int idInsert;
	
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		terreno = new Terreno();
		inmueble = new Inmueble();
	}

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public int getIdInsert() {
		return idInsert;
	}

	public void setIdInsert(int idInsert) {
		this.idInsert = idInsert;
	}
	
	public String guardarTerreno() {
		buscarInmueble();
		String redirect = "";
		if(terrenoBussines.guardarTerreno(terreno, inmueble)) {
			redirect = "inmuebles.xhtml?faces-redirect=true";
		} else {
			redirect = "";
		}
		return redirect;
	}
	
	public void buscarInmueble() {
		inmueble = terrenoBussines.buscarInmueble(idInsert);
	}

}
