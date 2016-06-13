package digital.curioso.balada.util;

public class Sessao {

	private String email;
	private String nome;
	private String token;
	private ErrorMessage mensagem;

	public Sessao(String email, String nome, String token) {
		super();
		this.email = email;
		this.nome = nome;
		this.token = token;
		this.mensagem = new ErrorMessage(0, "");
	}
	
	public Sessao(String email, String nome, String token, ErrorMessage mensagem) {
		super();
		this.email = email;
		this.nome = nome;
		this.token = token;
		this.mensagem = mensagem;
	}	

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}

	public ErrorMessage getMensagem() {
		return mensagem;
	}

	public void setMensagem(ErrorMessage mensagem) {
		this.mensagem = mensagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
