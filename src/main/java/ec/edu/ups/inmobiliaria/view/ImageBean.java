package ec.edu.ups.inmobiliaria.view;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

import ec.edu.ups.inmobiliaria.dao.FotoDao;
import ec.edu.ups.inmobiliaria.modelo.Foto;
//esta clase  se guardara la foto 
@Named
@ApplicationScoped
public class ImageBean {
	
	private Foto foto;
	
	@EJB
	private FotoDao service;
	//metodo con la cual  la foto  utilizando uploadfile  le guardara en la  base  como bytes
	public byte[] getBytes(int id) {
		foto= service.buscarFoto(id);
		return foto.getDir();
	}

}
