package modelo;

public class Reserva {
	// Atributos
	private int id;
	private String origem;
	private String destino;
	private String ida;
	private String volta;
	private double valor;
	private int acompanhantes;
	
	//Construtores
	public Reserva () {
		
	}
	public Reserva( String origem, String destino, String ida, String volta, double valor, int acompanhantes) {
		this.origem = origem;
		this.destino = destino;
		this.ida = ida;
		this.volta = volta;
		this.valor = valor;
		this.acompanhantes = acompanhantes;
	}
	
	public Reserva(int posicao, String origem1, String ida1, String volta1, int acompanhantes1, double valor1) {
		// TODO Auto-generated constructor stub
	}
	
	//Gets e Sets
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getIda() {
		return ida;
	}
	public void setIda(String ida) {
		this.ida = ida;
	}
	public String getVolta() {
		return volta;
	}
	public void setVolta(String volta) {
		this.volta = volta;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getAcompanhantes() {
		return acompanhantes;
	}
	public void setAcompanhantes(int acompanhantes) {
		this.acompanhantes = acompanhantes;
	}
	
	//Métodos
		@Override
		public String toString() {
			return "Reserva [id=" + id + ", origem=" + origem + ", destino=" + destino + ", ida=" + ida + ", volta=" + volta
					+ ", valor=" + valor + ", acompanhantes=" + acompanhantes + "]";
		}
}
