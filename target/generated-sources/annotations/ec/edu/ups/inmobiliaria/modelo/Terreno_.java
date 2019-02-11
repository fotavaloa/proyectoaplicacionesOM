package ec.edu.ups.inmobiliaria.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Terreno.class)
public abstract class Terreno_ {

	public static volatile SingularAttribute<Terreno, String> dimensiones;
	public static volatile SingularAttribute<Terreno, Inmueble> inmuebleTerreno;
	public static volatile SingularAttribute<Terreno, String> titulo;
	public static volatile SingularAttribute<Terreno, Integer> id;
	public static volatile SingularAttribute<Terreno, String> suelo;

}

