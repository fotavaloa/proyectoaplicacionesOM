package ec.edu.ups.inmobiliaria.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Persona.class)
public abstract class Persona_ {

	public static volatile SingularAttribute<Persona, String> password;
	public static volatile SetAttribute<Persona, Inmueble> inmueblePersona;
	public static volatile SingularAttribute<Persona, String> ciudad;
	public static volatile SingularAttribute<Persona, String> correo;
	public static volatile SetAttribute<Persona, Oferta> ofertaPersona;
	public static volatile SingularAttribute<Persona, Integer> id;
	public static volatile SingularAttribute<Persona, String> telefono;
	public static volatile SingularAttribute<Persona, String> nombre;
	public static volatile SingularAttribute<Persona, String> pais;

}

