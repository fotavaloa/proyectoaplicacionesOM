package ec.edu.ups.inmobiliaria.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Departamento.class)
public abstract class Departamento_ {

	public static volatile SingularAttribute<Departamento, String> servicios;
	public static volatile SingularAttribute<Departamento, String> dimensiones;
	public static volatile SingularAttribute<Departamento, Integer> habitaciones;
	public static volatile SingularAttribute<Departamento, String> titulo;
	public static volatile SingularAttribute<Departamento, Inmueble> inmuebleDepartamento;
	public static volatile SingularAttribute<Departamento, Integer> id;

}

