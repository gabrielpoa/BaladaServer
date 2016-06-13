package digital.curioso.balada.bo;

import javax.ejb.Stateless;
import javax.inject.Inject;

import digital.curioso.balada.dao.UsuarioDao;
import digital.curioso.balada.model.Usuario;
import digital.curioso.balada.util.SegurancaUtil;

@Stateless
public class UsuarioBO {

	@Inject
	SegurancaUtil seguranca;
	
	@Inject
	UsuarioDao usuarioDAO;
	
	public void incluir (Usuario usuario) {
		usuario.setSenha(seguranca.segurancaCripto(usuario.getSenha()));
		usuarioDAO.setUsuario(usuario);
	}
	
	public Usuario getUsuarioPorEmailSenha(Usuario usuario) {
		usuario.setSenha(seguranca.segurancaCripto(usuario.getSenha()));
		return usuarioDAO.getUsuarioPorEmailSenha(usuario);
	}
}
