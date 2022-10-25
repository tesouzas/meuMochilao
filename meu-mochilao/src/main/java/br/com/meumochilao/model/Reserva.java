package br.com.meumochilao.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String origem;

	@Column(nullable = false)
	private String destino;

	@Column(nullable = false)
	private Long ida;

	@Column(nullable = false)
	private Long volta;
	
	@Column(nullable = false)
	private Long rg;
	
	@Column(nullable = false)
	private Long cpf;
	
	@Column(nullable = false)
	private Long acompanhantes;
	
	@Column(nullable = false)
	private String hospeedagem;

	@Column(nullable = false)
	private String transporte;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Long getIda() {
		return ida;
	}

	public void setIda(Long ida) {
		this.ida = ida;
	}

	public Long getVolta() {
		return volta;
	}

	public void setVolta(Long volta) {
		this.volta = volta;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public Long getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(Long acompanhantes) {
		this.acompanhantes = acompanhantes;
	}

	public String getHospeedagem() {
		return hospeedagem;
	}

	public void setHospeedagem(String hospeedagem) {
		this.hospeedagem = hospeedagem;
	}

	public String getTransporte() {
		return transporte;
	}

	public void setTransporte(String transporte) {
		this.transporte = transporte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acompanhantes, cpf, destino, hospeedagem, id, ida, origem, rg, transporte, volta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(acompanhantes, other.acompanhantes) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(destino, other.destino) && Objects.equals(hospeedagem, other.hospeedagem)
				&& Objects.equals(id, other.id) && Objects.equals(ida, other.ida)
				&& Objects.equals(origem, other.origem) && Objects.equals(rg, other.rg)
				&& Objects.equals(transporte, other.transporte) && Objects.equals(volta, other.volta);
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", origem=" + origem + ", destino=" + destino + ", ida=" + ida + ", volta=" + volta
				+ ", rg=" + rg + ", cpf=" + cpf + ", acompanhantes=" + acompanhantes + ", hospeedagem=" + hospeedagem
				+ ", transporte=" + transporte + "]";
	}

	
	







}