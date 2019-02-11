package ec.edu.ups.inmobiliaria.modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Oferta.class)
public abstract class Oferta_ {

	public static volatile SingularAttribute<Oferta, Date> fecha;
	public static volatile SingularAttribute<Oferta, Double> monto;
	public static volatile SingularAttribute<Oferta, Persona> ofertaPersona;
	public static volatile SingularAttribute<Oferta, Integer> id;
	public static volatile SingularAttribute<Oferta, Inmueble> inmuebleOferta;

}

