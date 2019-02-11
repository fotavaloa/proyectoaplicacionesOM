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
//creacion de  la entidad con sus respectivos atributos
@Entity
public class Casa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //genera el id automaticamente
	@Column(name="casaId")
	private int id;
	
	@Column(name="casaTitulo")
	private String titulo;
	
	@Column(name="casaDimensiones")
	private String dimensiones;
	
	@Column(name="casaPlantas")
	private int plantas;
	
	@Column(name="casaHabitaciones")
	private int habitaciones;
	
	@Column(name="casaServicios")
	private String servicios;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="casaInmId")
	private Inmueble inmuebleCasa;

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

	public int getPlantas() {
		return plantas;
	}

	
	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public void setPlantas(int plantas) {
		this.plantas = plantas;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	public Inmueble getInmuebleCasa() {
		return inmuebleCasa;
	}

	public void setInmuebleCasa(Inmueble inmuebleCasa) {
		this.inmuebleCasa = inmuebleCasa;
	}
	
	
	
	

}
