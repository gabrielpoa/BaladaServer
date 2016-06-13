package digital.curioso.balada.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import digital.curioso.balada.bo.UsuarioBO;
import digital.curioso.balada.model.Usuario;

@Path("/usuarios")
public class UsuarioRest {
	
	@Inject
	UsuarioBO usuarioBO;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	/*@Produces({ MediaType.MEDIA_TYPE_WILDCARD})*/
	public Response inclui(Usuario usuario) {
		
		usuarioBO.incluir(usuario);
		
		return Response.status(Response.Status.OK).build();
	}
	
	@GET
	@Path("login")
	@Produces({ MediaType.MEDIA_TYPE_WILDCARD})
	public Response login(@HeaderParam("email") String email, @HeaderParam("senha") String senha) {
		
		Usuario usuario = new Usuario(email, senha);
		
		usuario = usuarioBO.getUsuarioPorEmailSenha(usuario);
		
		if (usuario == null)
			return Response.status(203).build();
		
		return Response.ok(usuario, MediaType.APPLICATION_JSON).build();
	}	
	
	@GET
	/*@Produces({ MediaType.MEDIA_TYPE_WILDCARD})*/
	@Produces(MediaType.TEXT_PLAIN)
	public Response get() {

		return Response.status(Response.Status.OK).entity("Teste rest").build();
		
	}
}

