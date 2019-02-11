package ec.edu.ups.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Oferta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ofeId")
	private int id;
	
	@Column(name="ofeMonto")
	private double monto;
	
	@Column(name="ofeFecha")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="ofePerId")
	private Persona ofertaPersona;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ofeInmID")
	private Inmueble inmuebleOferta;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Persona getOfertaPersona() {
		return ofertaPersona;
	}

	public void setOfertaPersona(Persona ofertaPersona) {
		this.ofertaPersona = ofertaPersona;
	}

	public Inmueble getInmuebleOferta() {
		return inmuebleOferta;
	}

	public void setInmuebleOferta(Inmueble inmuebleOferta) {
		this.inmuebleOferta = inmuebleOferta;
	}
	
	
	
	
	
	

}
