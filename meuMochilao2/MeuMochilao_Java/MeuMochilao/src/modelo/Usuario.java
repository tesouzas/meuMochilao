package modelo;

public class Usuario {

	// Atributos
	private int id;
	private String login;
	private String senha;
	private int fone;
	private String nome;
	private Permissoes permissoes;
	
	// Contrutores
	public Usuario () {
		
	}
	public Usuario(int id, String nome,  int fone, String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.fone = fone;
		this.nome = nome;
		this.permissoes = permissoes;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getFone() {
		return fone;
	}
	public void setFone(int fone) {
		this.fone = fone;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Permissoes getPermissoes() {
		return permissoes;
	}
	public void setPermissoes(Permissoes permissoes) {
		this.permissoes = permissoes;
	}

	//Métodos

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", fone=" + fone + ", nome=" + nome
				+ ", permissoes=" + permissoes + "]";
	}
}