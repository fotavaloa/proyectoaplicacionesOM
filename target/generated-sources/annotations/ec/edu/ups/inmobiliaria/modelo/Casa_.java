package ec.edu.ups.inmobiliaria.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Casa.class)
public abstract class Casa_ {

	public static volatile SingularAttribute<Casa, String> servicios;
	public static volatile SingularAttribute<Casa, String> dimensiones;
	public static volatile SingularAttribute<Casa, Integer> plantas;
	public static volatile SingularAttribute<Casa, String> titulo;
	public static volatile SingularAttribute<Casa, Integer> id;
	public static volatile SingularAttribute<Casa, Inmueble> inmuebleCasa;

}

