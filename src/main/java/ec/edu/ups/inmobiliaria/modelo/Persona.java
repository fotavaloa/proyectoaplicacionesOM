package ec.edu.ups.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Persona implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="perId")
	private int id;
	
	@Column(name="perNombre")
	private String nombre;
	
	@Column(name="perCorreo")
	private String correo;
	
	@Column(name="perPass")
	private String password;
	
	@Column(name="perPais")
	private String pais;
	
	@Column(name="perCiudad")
	private String ciudad;
	
	@Column(name="perTelefono")
	private String telefono;
	
	
	@OneToMany (mappedBy="inmueblePersona", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-persona")
	private List<Inmueble> inmueblePersona;

	@OneToMany (mappedBy="ofertaPersona", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-oferta")
	private List<Oferta> ofertaPersona;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public List<Inmueble> getInmueblePersona() {
		return inmueblePersona;
	}

	public void setInmueblePersona(List<Inmueble> inmueblePersona) {
		this.inmueblePersona = inmueblePersona;
	}

	public List<Oferta> getOfertaPersona() {
		return ofertaPersona;
	}

	public void setOfertaPersona(List<Oferta> ofertaPersona) {
		this.ofertaPersona = ofertaPersona;
	}
	

	
	
	
	
	
	

}
