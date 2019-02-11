package ec.edu.ups.inmobiliaria.bussiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import ec.edu.ups.inmobiliaria.dao.FotoDao;
import ec.edu.ups.inmobiliaria.dao.InmuebleDao;
import ec.edu.ups.inmobiliaria.dao.PersonaDao;
import ec.edu.ups.inmobiliaria.modelo.Foto;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;
import ec.edu.ups.inmobiliaria.modelo.Persona;

@Stateless
public class InmuebleBussiness {
	//inyecta los dao de  los inmuebles  y de las  fotos  para su registro
	@Inject
	private InmuebleDao inmuebleDao;
	
	@Inject
	private FotoDao fotoDao;
	
	@Inject
	private PersonaDao personaDao;
	//registra el inmueble  incluyendo con su  id  respectivo  
	//funcion 9 subir la imagen  utilizando  uploadedfile  para que convierta  en bytes y guarde a la base
	public String guardarInmueble(Inmueble inmueble, int id, Foto foto, UploadedFile file ) throws IOException {
		String redirect ="";
		
		Inmueble inm = inmuebleDao.buscarInmueble(inmueble.getId());
		Persona per = personaDao.buscarPersona(id);
		
		if (inm==null) {
			//la funcion fecha  se guarda automaticamente  con la hora del sistema
			Date currenDate = new Date();
			inmueble.setFechapublicacion(currenDate);
			inmueble.setEstado("Activa");
			inmueble.setVendido("no");
			inmueble.setVisitas(0);
			inmueble.setInmueblePersona(per);
			foto.setDir(IOUtils.toByteArray(file.getInputstream()));
			switch (inmueble.getTipo()) {///escoge la opcion  del tipo de inmueble para cargar y guardar  foto 
			//direcionando a la pagina  para llenar los campos  de  el tipo de imueble
			case "Terreno":
				inmuebleDao.insertarInmueble(inmueble);
				foto.setInmuebleFoto(inmueble);
				fotoDao.guardarFoto(foto);
				redirect="terreno.xhtml?faces-redirect=true&id="+inmueble.getId();
				break;
			case "Casa":
				inmuebleDao.insertarInmueble(inmueble);
				foto.setInmuebleFoto(inmueble);
				fotoDao.guardarFoto(foto);
				redirect="casa.xhtml?faces-redirect=true&id="+inmueble.getId();
				break;
			case "Departamento":
				inmuebleDao.insertarInmueble(inmueble);
				foto.setInmuebleFoto(inmueble);
				fotoDao.guardarFoto(foto);
				redirect="departamento.xhtml?faces-redirect=true&id="+inmueble.getId();
				break;
			case "Edificio":
				inmuebleDao.insertarInmueble(inmueble);
				foto.setInmuebleFoto(inmueble);
				fotoDao.guardarFoto(foto);
				redirect="edificio.xhtml?faces-redirect=true&id="+inmueble.getId();
				break;
			default:
				break;
			}
					
		}else {
			redirect="Algo salio mal!";
		}
		return redirect;
	}
	
	//funcion del listado por  fecha
	public List<Inmueble> listaInmuebles(){
		return inmuebleDao.ListarInmuebles();
	}
	//para  ver  detalladamente   el inmuebel que se a sellecionado de un listado  
	public String verInmueble(Inmueble inmueble, int idInmueble) {
		String redirect = null;
		inmueble = inmuebleDao.buscarInmueble(idInmueble);
		inmueble.setVisitas(inmueble.getVisitas() + 1);

		if (inmueble.getTipo().equals("Terreno")) {
			inmuebleDao.actualizarInmueble(inmueble);
			redirect = "vista_terreno.xhtml?faces-redirect=true&id=" + inmueble.getId();
		} else if (inmueble.getTipo().equals("Casa")) {
			inmuebleDao.actualizarInmueble(inmueble);
			redirect = "vista_casa.xhtml?faces-redirect=true&id=" + inmueble.getId();
		} else if (inmueble.getTipo().equals("Departamento")) {
			inmuebleDao.actualizarInmueble(inmueble);
			redirect = "vista_departamento.xhtml?faces-redirect=true&id=" + inmueble.getId();
		} else if (inmueble.getTipo().equals("Edificio")) {
			inmuebleDao.actualizarInmueble(inmueble);
			redirect = "vista_edificio.xhtml?faces-redirect=true&id=" + inmueble.getId();
		}

		return redirect;
	}
	
	public Inmueble buscarInmueble(int id) {
		Inmueble inmueble = inmuebleDao.buscarInmueble(id);
		return inmueble;
	}
	// busca el tipo de inmueble  atrves de un filtro
	public List<Inmueble> listarInmueblesFiltro(String filtro){
		List<Inmueble> lst = new ArrayList<>();
		if (filtro.equals("Vistas")) {
			lst = inmuebleDao.ListarInmuebleVisitas();
		} else if (filtro.equals("Precio")) {
			lst = inmuebleDao.ListarInmueblePrecio();
		}
		return lst;
	} 
	/////rest
	
	public List<Inmueble> listarInmueblesVistas(){
		return inmuebleDao.ListarInmuebleVisitas();
	}
	
	public List<Inmueble> listarInmueblesPrecio(){
		return inmuebleDao.ListarInmueblePrecio();
	}
	

}
