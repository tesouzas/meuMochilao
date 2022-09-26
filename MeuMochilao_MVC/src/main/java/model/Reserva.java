package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reserva {
	private int id;
	private LocalDate ida;
	private LocalDate volta;
	private double valor_total;
	private long dias;
	
	private Cliente cliente;
	private Viagem viagem;
	
	// classe responsavel por formatar um padrao diferente do formato ISO
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reserva() {
		super();
	}

	public Reserva(String ida, String volta, Cliente cliente, Viagem viagem) {
		super();
		this.ida = LocalDate.parse(ida, formatter);
		this.volta = LocalDate.parse(volta, formatter);	
		// retorna a quantidade de dias entre as datas 
		this.dias = setPeriodo(this.ida, this.volta);
		// metodo faz a operação de mutiplicação do valor de aluguel do carro vezes os dias.
		this.valor_total = setValor_dias(viagem.getValor_pacote());	
		this.cliente = cliente;
		this.viagem = viagem;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIda() {
		return formatter.format(ida);
	}

	public void setIda(String ida) {
		this.ida = LocalDate.parse(ida, formatter);
	}

	public String getVolta() {
		return formatter.format(volta);
	}

	public void setVolta(String volta) {
		this.volta = LocalDate.parse(volta, formatter);
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	
	public double setValor_dias(double valor_total) {
		this.valor_total = valor_total * dias;
		return this.valor_total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public long getDias() {
		return dias;
	}

	public void setDias(long dias) {
		this.dias = dias;
	}		
	
	public long setPeriodo(LocalDate ida, LocalDate volta) {
		this.dias =  ChronoUnit.DAYS.between(this.ida, this.volta);
		return this.dias;
	}	
	
}
