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
public class Terreno implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="terId")
	private int id;
	
	@Column(name="terTitulo")
	private String titulo;
	
	@Column(name="terDimensiones")
	private String dimensiones;
	
	@Column(name="tersuelo")
	private String suelo;
	

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="terInmId")
	private Inmueble inmuebleTerreno;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public String getSuelo() {
		return suelo;
	}

	public void setSuelo(String suelo) {
		this.suelo = suelo;
	}

	public Inmueble getInmuebleTerreno() {
		return inmuebleTerreno;
	}

	public void setInmuebleTerreno(Inmueble inmuebleTerreno) {
		this.inmuebleTerreno = inmuebleTerreno;
	}
	
	
	

}
