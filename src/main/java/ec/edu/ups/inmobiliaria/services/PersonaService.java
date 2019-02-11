package ec.edu.ups.inmobiliaria.services;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ec.edu.ups.inmobiliaria.bussiness.PersonaBussiness;
import ec.edu.ups.inmobiliaria.modelo.Inmueble;
import ec.edu.ups.inmobiliaria.modelo.Persona;

@Path("/personas")
public class PersonaService {
	
	@Inject
	private PersonaBussiness pBussiness;
	//listado de las personas  registradas
	@GET
	@Path("/listapersonas")
	@Produces ("application/json")
	public List<Persona> ListadoPersona()
	{
			return pBussiness.listarp();
	}
	
	//consulta  de persona  para el inicion de sesion
	@POST
	@Path("/login")
	@Consumes ("application/json") 
	@Produces ("application/json")
	public String login(@QueryParam("email") String email, @QueryParam("pass") String contra) {
		String ret="";
		if (pBussiness.loginWS(email, contra)) {
			ret="400";
			
		}else {
			ret="200";
		}
		return ret;
	}
	
//registro  de la persona 
	@POST
	@Path ("/insert")
	@Consumes("application/json")
	@Produces ("application/json")
	public Response insertaPersona(Persona persona) {
		
		Response.ResponseBuilder builder = null;
		
		Map<String, String> data = new HashMap<>();
		
		try {
			pBussiness.guardarPersona(persona);
			data.put("code", "1");
			data.put("message", "OK");
			builder = Response.status(Response.Status.OK).entity(data);  //debuelve el resultado  con un ok cod200
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			data.put("code", "99");
			data.put("message", e.getMessage());
			builder = Response.status(Response.Status.OK).entity(data);
		}
		
		return builder.build();
		
	}
	
	

}
