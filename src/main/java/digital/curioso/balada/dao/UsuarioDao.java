package digital.curioso.balada.dao;

import javax.ejb.Stateless;

import org.bson.Document;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

import digital.curioso.balada.model.Usuario;
import digital.curioso.balada.util.Connection;

@Stateless
public class UsuarioDao {
	
	
	public Usuario getUsuarioPorEmailSenha(Usuario usuario) {
	
		Connection db = new Connection("Usuarios"); 
		
		BasicDBObject query = new BasicDBObject("email", usuario.getEmail()).append("senha", usuario.getSenha());
		
		Document usuarioDoc = db.getCollection().find(query).first();
		
		if (usuarioDoc != null && !usuarioDoc.isEmpty()) {
			Gson gson = new Gson();
			usuario = gson.fromJson(usuarioDoc.toJson(), Usuario.class);
		} else 
			return null;
			
		db.Close();
		
		return usuario;
	}	
	
	public Usuario setUsuario(Usuario usuario) {

		Gson gson = new Gson();
		Connection db = new Connection("Usuarios"); 
		db.getCollection().insertOne(Document.parse(gson.toJson(usuario)));
		db.Close();
		
		
		return usuario;
	}	
	
}
