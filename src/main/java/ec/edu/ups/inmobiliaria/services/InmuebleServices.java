package ec.edu.ups.inmobiliaria.services;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.inmobiliaria.bussiness.InmuebleBussiness;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;

@Path("/inmuebles")
public class InmuebleServices {

	
	@Inject 
	private InmuebleBussiness inBussiness;
	
	///listar los inmuebles por  fecha
	
	@GET
	@Path("/listaInmueble")
	@Produces ("application/json") //fomrato  va devlover
	public List<Inmueble> getInmueblesL()
	{
			return inBussiness.listaInmuebles();
	}
	

	///listar los inmuebles por  filtro
	
	@GET
	@Path("/listaInmueblefiltro")
	@Produces ("application/json") //fomrato  va devlover
	public List<Inmueble> getInmueblesLF(@QueryParam("filtro") String filtro)
	{
		System.out.println(filtro);
			return inBussiness.listarInmueblesFiltro(filtro);
	}
	
	///listar por vistas
	@GET
	@Path("/listaInmuebleVistas")
	@Produces ("application/json")
	public List<Inmueble> ListadoVistasInm()
	{
			return inBussiness.listarInmueblesVistas();
	}
	///listar por precio
		@GET
		@Path("/listaInmueblePrecio")
		@Produces ("application/json")
		public List<Inmueble> ListadoPrecioInm()
		{
				return inBussiness.listarInmueblesPrecio();
		}
}
