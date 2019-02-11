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
public class Departamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="depId")
	private int id;
	
	@Column(name="depTitulo")
	private String titulo;
	
	@Column(name="depDimensiones")
	private String dimensiones;
	
	@Column(name="depHabitaciones")
	private int habitaciones;
	
	@Column(name="depServicios")
	private String servicios;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="depInmId")
	private Inmueble inmuebleDepartamento;
	

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

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public Inmueble getInmuebleDepartamento() {
		return inmuebleDepartamento;
	}

	public void setInmuebleDepartamento(Inmueble inmuebleDepartamento) {
		this.inmuebleDepartamento = inmuebleDepartamento;
	}
	
	
	
	
	
}
