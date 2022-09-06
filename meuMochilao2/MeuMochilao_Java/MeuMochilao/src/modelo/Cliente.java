package modelo;

public class Cliente {
	
	//Atributos
	private int id;
	private String nome;
	private int rg;
	private int cpf;
	private String email;
	private String rua;
	private String cidade;
	private String estado;
	private String complemento;
	
	//Construtores
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, int rg, int cpf, String email, String rua, String cidade, String estado,
			String complemento) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.email = email;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}
	
	//gets e sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
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
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
	//Métodos
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", email=" + email + ", rua="
				+ rua + ", cidade=" + cidade + ", estado=" + estado + ", complemento=" + complemento + "]";
	}
	
	
	
}
