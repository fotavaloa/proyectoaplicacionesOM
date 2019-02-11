package ec.edu.ups.inmobiliaria.view;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.primefaces.model.UploadedFile;

import ec.edu.ups.inmobiliaria.bussiness.InmuebleBussiness;
import ec.edu.ups.inmobiliaria.modelo.Foto;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@ManagedBean
@RequestScoped
public class InmuebleBean {
	
	@Inject
	private InmuebleBussiness inmuebleBussiness;
	
	private Inmueble inmueble;
	
	private Foto foto;
	
	private int idInsert;
	
	UploadedFile file;
	
	private List<Inmueble> listaInmuebles;
	
	@PostConstruct
	private void init() {
		// TODO Auto-generated method stub
		inmueble = new Inmueble();
		foto = new Foto();
		listarInmuebles();
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
	public int getIdInsert() {
		return idInsert;
	}

	public void setIdInsert(int idInsert) {
		this.idInsert = idInsert;
	}

	public Foto getFoto() {
		return foto;
	}

	public void setFoto(Foto foto) {
		this.foto = foto;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	
	public List<Inmueble> getListaInmuebles() {
		return listaInmuebles;
	}

	public void setListaInmuebles(List<Inmueble> listaInmuebles) {
		this.listaInmuebles = listaInmuebles;
	}

	public String guardarInmueble(int id) throws IOException {
		return inmuebleBussiness.guardarInmueble(inmueble, id, foto, file);
	}
	
	public void listarInmuebles() {
		listaInmuebles = inmuebleBussiness.listaInmuebles();
	}
	
	public String verInmbueble(int id) {
		return inmuebleBussiness.verInmueble(inmueble, id);
	}
	
	public void buscarInmueble() {
		inmueble = inmuebleBussiness.buscarInmueble(idInsert);
	}
	
	public void listarInmueblesFiltro(String filtro) {
		listaInmuebles = inmuebleBussiness.listarInmueblesFiltro(filtro);
	}

}
