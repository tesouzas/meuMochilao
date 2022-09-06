package modelo;

public class Hospedagem {
	// Atributos
	private int id;
	private String nome;
	private double valor;
	private int qtddias;
	
	//Construtor
	public Hospedagem () {
		
	}
	public Hospedagem(int id, String nome, double valor, int qtddias) {
		
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.qtddias = qtddias;
	}
	
	//Gets e Sets
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getQtddias() {
		return qtddias;
	}
	public void setQtd_dias(int qtddias) {
		this.qtddias = qtddias;
	}

	//Métodos
	@Override
	public String toString() {
		return "Hospedagem [id=" + id + ", nome=" + nome + ", valor=" + valor + ", qtddias=" + qtddias
				+ "]";
	}
	
	
	
}
