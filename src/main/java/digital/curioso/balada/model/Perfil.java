package digital.curioso.balada.model;

import java.io.Serializable;

public class Perfil  {

	private Integer idPerfil;
	
	private String permissao;
	
	private String descricao;

	
	public Perfil() {
		super();
	}


	public Integer getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}


	public String getPermissao() {
		return permissao;
	}


	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}




}
