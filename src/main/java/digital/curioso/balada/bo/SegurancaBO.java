package digital.curioso.balada.bo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;

import digital.curioso.balada.dao.UsuarioDao;
import digital.curioso.balada.model.Usuario;
import digital.curioso.balada.util.SegurancaUtil;
import digital.curioso.balada.util.Sessao;

public class SegurancaBO {

	@Inject
	SegurancaUtil segurancaUtil;
	
	@Inject
	UsuarioDao usuarioDao;
	
	public Sessao login(Usuario usuario) {
		
		String senha = segurancaUtil.segurancaCripto(usuario.getSenha());
		
		usuario.setSenha(senha);
		
		usuario = usuarioDao.getUsuarioPorEmailSenha(usuario);
		
		//if (usuario.getIdUsuario() != null) {
			return (new Sessao(usuario.getEmail(), usuario.getNome(), this.getTokenLogin(usuario)));
		//}

		//return (new Sessao(usuario.getEmail(), "", "", new ErrorMessage(1, "Ops, E-mail ou Senha informados estão incorretos.")));
	}	
	
	public void incluir (Usuario usuario) {
		usuarioDao.setUsuario(usuario);
	}
	
	private String getTokenLogin(Usuario usuario) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		//String token = usuario.getIdUsuario() + ";" + sdf.format(cal.getTime()) + ";" + sdf.format(cal.getTime());
		
		String token = "0000";
		
		//System.out.println(sdf.parse(sdf));
		// Output "Wed Sep 26 00:00:00 EST 2012"		
		
		return segurancaUtil.encrypt(token, usuario.getSenha());
	}
}
