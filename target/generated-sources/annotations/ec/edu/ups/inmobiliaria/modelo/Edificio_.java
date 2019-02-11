package ec.edu.ups.inmobiliaria.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Edificio.class)
public abstract class Edificio_ {

	public static volatile SingularAttribute<Edificio, Integer> plantas;
	public static volatile SingularAttribute<Edificio, Integer> locales;
	public static volatile SingularAttribute<Edificio, Integer> departamentos;
	public static volatile SingularAttribute<Edificio, String> titutlo;
	public static volatile SingularAttribute<Edificio, Inmueble> inmuebleEdificio;
	public static volatile SingularAttribute<Edificio, Integer> id;

}

