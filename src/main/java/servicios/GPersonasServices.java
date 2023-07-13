package servicios;

import java.util.List;

import Dao.PersonaDAO;
import Negocio.GestionPersonas;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import Modelo.Persona;

@Path("clientes")
public class GPersonasServices {

	@Inject
	private GestionPersonas gClientes;
	@Inject 
	private PersonaDAO daoPersona;

	
	@GET
    @Path("listarPersona")
    @Produces("application/json")
    public List<Persona> listarPersonas() {
        return daoPersona.getAll();
	}
	
	@POST	
	@Path("Listar")
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarPersona(Persona persona) {
		try {
			gClientes.guardarPersonas(persona);
			return Response.status(Response.Status.OK).entity(persona).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(100);
			error.setMensaje("Error al guardar: " +e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
}
