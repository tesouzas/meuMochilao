package modelo;

public class Transporte {
	// Atributos
	private int id;
	private String nome;
	private double valor;
	
	//Construtores
	public Transporte() {
		
	}
	
	public Transporte(int id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	//Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String Nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double d) {
		this.valor = d;
	}
	
	//Métodos
	@Override
	public String toString() {
		return "Transporte [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}


	
}
