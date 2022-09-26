package model;

public class Viagem {
	private int id;
	private String destino;
	private String pacote;
	private double valor_pacote;
	
	public Viagem() {
		super();
	}
	
	public Viagem(int id, String destino, String pacote, double valor_pacote) {
		super();
		this.id = id;
		this.destino = destino;
		this.pacote = pacote;
		this.valor_pacote = valor_pacote;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getPacote() {
		return pacote;
	}

	public void setPacote(String pacote) {
		this.pacote = pacote;
	}

	public double getValor_pacote() {
		return valor_pacote;
	}

	public void setValor_pacote(double valor_pacote) {
		this.valor_pacote = valor_pacote;
	}

	@Override
	public String toString() {
		return "Carro [id=" + id + ", destino=" + destino + ", pacote=" + pacote + ", valor_pacote=" + valor_pacote + "]";
	}
	
	
	
}