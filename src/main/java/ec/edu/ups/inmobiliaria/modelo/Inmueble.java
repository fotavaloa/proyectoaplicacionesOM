package ec.edu.ups.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Inmueble implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//asigando la  id automatico 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="inmId")
	private int id;
	
	@Column(name="inmLat")
	private double lat;
	
	@Column(name="inmLng")
	private double lng;
	
	@Column(name="inmTipo")
	private String tipo;
	
	@Column(name="inmDireccion")
	private String direccion;
	
	@Column(name="inmCiudad")
	private String ciudad;
	
	@Column(name="inmCaracteristicas")
	private String caracteristicas;
	
	@Column(name="inmPrecio")
	private int precio;
	
	@Column(name="inmFechaPublicacion")
	private Date fechapublicacion;
	
	@Column(name="inmFormaPago")
	private String formapago;
	
	@Column(name="inmEstado")
	private String estado;
	
	@Column(name="inmVendido")
	private String vendido;
	
	@Column(name="inmVisitas")
	private int visitas;
	//relacion bidirecional
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="inmPerId")
	private Persona inmueblePersona;
	

	@OneToMany(mappedBy="inmuebleOferta", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-ofer")
	private Set<Oferta> inmuebleOferta;
	
	@OneToOne(mappedBy="inmuebleTerreno", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-terr")
	private Terreno inmuebleTerreno;
	
	@OneToOne(mappedBy="inmuebleCasa", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-cas")
	private Casa inmuebleCasa;
	
	@OneToOne(mappedBy="inmuebleDepartamento", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-deep")
	private Departamento inmuebleDepartamento;
	
	@OneToOne(mappedBy="inmuebleEdificio", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-edif")
	private Edificio inmuebleEdificio;
	
	@OneToOne(mappedBy="inmuebleFoto", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JsonBackReference(value="inmueble-foto")
	private Foto inmuebleFoto;
	
	//creacion de los  getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Date getFechapublicacion() {
		return fechapublicacion;
	}
	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}
	public String getFormapago() {
		return formapago;
	}
	public void setFormapago(String formapago) {
		this.formapago = formapago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getVendido() {
		return vendido;
	}
	public void setVendido(String vendido) {
		this.vendido = vendido;
	}
	public int getVisitas() {
		return visitas;
	}
	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}
	public Persona getInmueblePersona() {
		return inmueblePersona;
	}
	public void setInmueblePersona(Persona inmueblePersona) {
		this.inmueblePersona = inmueblePersona;
	}
//	public Set<Oferta> getInmuebleOferta() {
//		return inmuebleOferta;
//	}
//	public void setInmuebleOferta(Set<Oferta> inmuebleOferta) {
//		this.inmuebleOferta = inmuebleOferta;
//	}
	
	public Terreno getInmuebleTerreno() {
		return inmuebleTerreno;
	}
	
	public Set<Oferta> getInmuebleOferta() {
		return inmuebleOferta;
	}
	public void setInmuebleOferta(Set<Oferta> inmuebleOferta) {
		this.inmuebleOferta = inmuebleOferta;
	}
	public void setInmuebleTerreno(Terreno inmuebleTerreno) {
		this.inmuebleTerreno = inmuebleTerreno;
	}
	public Casa getInmuebleCasa() {
		return inmuebleCasa;
	}
	public void setInmuebleCasa(Casa inmuebleCasa) {
		this.inmuebleCasa = inmuebleCasa;
	}
	public Departamento getInmuebleDepartamento() {
		return inmuebleDepartamento;
	}
	public void setInmuebleDepartamento(Departamento inmuebleDepartamento) {
		this.inmuebleDepartamento = inmuebleDepartamento;
	}
	public Edificio getInmuebleEdificio() {
		return inmuebleEdificio;
	}
	public void setInmuebleEdificio(Edificio inmuebleEdificio) {
		this.inmuebleEdificio = inmuebleEdificio;
	}
	public Foto getInmuebleFoto() {
		return inmuebleFoto;
	}
	public void setInmuebleFoto(Foto inmuebleFoto) {
		this.inmuebleFoto = inmuebleFoto;
	}
	
	
	
	

}
