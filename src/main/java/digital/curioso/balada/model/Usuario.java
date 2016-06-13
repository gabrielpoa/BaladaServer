package digital.curioso.balada.model;

public class Usuario {

	private String nome;

	private String sobrenome;
	
	private String senha;

	private String email;	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(String email, String senha, String nome, String sobrenome) {
		super();
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}
