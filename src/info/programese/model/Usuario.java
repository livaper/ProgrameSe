package info.programese.model;

public class Usuario {
	private String nome;
	private String email;
	private String login;
	private String senha;
	private char tipo; // o tipo pode ser 'E' para estudante, 'P' para professor;
	private String cidade;
	private String estado;
	
	
	public Usuario(String nome, String email, String login, String senha, char tipo, String cidade, String estado) {
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public char getTipo() {
		return tipo;
	}
	public void setTipo(char tipo) {
		this.tipo = tipo;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
