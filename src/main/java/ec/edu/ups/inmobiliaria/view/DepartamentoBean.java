package ec.edu.ups.inmobiliaria.view;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import ec.edu.ups.inmobiliaria.bussiness.DepartamentoBussiness;
import ec.edu.ups.inmobiliaria.modelo.Departamento;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@ManagedBean
@RequestScoped
public class DepartamentoBean {
	//inyeccion de los  bussines
	@Inject
	private DepartamentoBussiness departamentoBussiness;
	
	private Departamento departamento;
	
	private Inmueble inmueble;
	
	private int idInsert;
	
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		departamento = new Departamento();
		inmueble = new Inmueble();
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public int getIdInsert() {
		return idInsert;
	}

	public void setIdInsert(int idInsert) {
		this.idInsert = idInsert;
	}
	//registro del  departametno  con su respectivo  inmueble   redirecionando a la pagina  de inmuebles
	public String guardarDepartamento() {
		buscarInmueble();
		String redirect = "";
		if(departamentoBussiness.guardarDepartamento(departamento, inmueble)) {
			redirect = "inmuebles.xhtml?faces-redirect=true";
		} else {
			redirect = "";
		}
		return redirect;
	}
	
	public void buscarInmueble() {
		inmueble = departamentoBussiness.buscarInmueble(idInsert);
	}

}
