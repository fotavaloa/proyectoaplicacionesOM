package ec.edu.ups.inmobiliaria.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Inmueble.class)
public abstract class Inmueble_ {

	public static volatile SingularAttribute<Inmueble, Terreno> inmuebleTerreno;
	public static volatile SingularAttribute<Inmueble, String> tipo;
	public static volatile SingularAttribute<Inmueble, String> caracteristicas;
	public static volatile SingularAttribute<Inmueble, String> estado;
	public static volatile SingularAttribute<Inmueble, Double> lng;
	public static volatile SingularAttribute<Inmueble, Foto> inmuebleFoto;
	public static volatile SingularAttribute<Inmueble, String> direccion;
	public static volatile SingularAttribute<Inmueble, Departamento> inmuebleDepartamento;
	public static volatile SingularAttribute<Inmueble, String> formapago;
	public static volatile SingularAttribute<Inmueble, Casa> inmuebleCasa;
	public static volatile SingularAttribute<Inmueble, Integer> visitas;
	public static volatile SingularAttribute<Inmueble, Integer> precio;
	public static volatile SingularAttribute<Inmueble, Date> fechapublicacion;
	public static volatile SingularAttribute<Inmueble, Persona> inmueblePersona;
	public static volatile SingularAttribute<Inmueble, String> ciudad;
	public static volatile SingularAttribute<Inmueble, Edificio> inmuebleEdificio;
	public static volatile SingularAttribute<Inmueble, String> vendido;
	public static volatile SingularAttribute<Inmueble, Integer> id;
	public static volatile SetAttribute<Inmueble, Oferta> inmuebleOferta;
	public static volatile SingularAttribute<Inmueble, Double> lat;

}

