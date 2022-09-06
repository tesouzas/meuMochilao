package modelo;

public class Permissoes {

	//Atributos
	private int id;
	private String tipo;
	
	//Construtor
	public Permissoes () {
		
	}
	
	public Permissoes(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	//Gets e Sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
	//Métodos
	@Override
	public String toString() {
		return "Permissoes [id=" + id + ", tipo=" + tipo + "]";
	}

	
}
