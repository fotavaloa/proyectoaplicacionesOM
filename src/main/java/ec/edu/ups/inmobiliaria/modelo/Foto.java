package ec.edu.ups.inmobiliaria.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Foto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fotId")
	private int id;
	//funcion 6 guardar la imagen en bytes en la base de datos
	@Column(name="fotDir")
	private byte[] dir;

	//bidireccional
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fotInmId")
	private Inmueble inmuebleFoto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getDir() {
		return dir;
	}

	public void setDir(byte[] dir) {
		this.dir = dir;
	}

	public Inmueble getInmuebleFoto() {
		return inmuebleFoto;
	}

	public void setInmuebleFoto(Inmueble inmuebleFoto) {
		this.inmuebleFoto = inmuebleFoto;
	}
	
	
	
	

}
