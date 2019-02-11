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
public class Edificio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ediId")
	private int id;
	
	@Column(name="ediTitulo")
	private String titulo;
	
	@Column(name="ediPlantas")
	private int plantas;
	
	@Column(name="ediDepartamentos")
	private int departamentos;
	
	@Column(name="ediLocales")
	private int locales;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ediInmId")
	private Inmueble inmuebleEdificio;
	
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

	public int getPlantas() {
		return plantas;
	}

	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}

	public int getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(int departamentos) {
		this.departamentos = departamentos;
	}

	public int getLocales() {
		return locales;
	}

	public void setLocales(int locales) {
		this.locales = locales;
	}

	public Inmueble getInmuebleEdificio() {
		return inmuebleEdificio;
	}

	public void setInmuebleEdificio(Inmueble inmuebleEdificio) {
		this.inmuebleEdificio = inmuebleEdificio;
	}
	
	

}
