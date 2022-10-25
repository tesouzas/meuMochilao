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
public class Cadastro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String senha;

	@Column(nullable = false)
	private Long rg;

	@Column(nullable = false)
	private Long telefone;
	
	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String estado;



	public Cadastro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cadastro(Long id, String nome, String email, String senha, Long rg, Long telefone, String cidade,
			String estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.rg = rg;
		this.telefone = telefone;
		this.cidade = cidade;
		this.estado = estado;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getRg() {
		return rg;
	}

	public void setRg(Long rg) {
		this.rg = rg;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
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

	@Override
	public int hashCode() {
		return Objects.hash(cidade, email, estado, id, nome, rg, senha, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cadastro other = (Cadastro) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(email, other.email)
				&& Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(rg, other.rg)
				&& Objects.equals(senha, other.senha) && Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", rg=" + rg
				+ ", telefone=" + telefone + ", cidade=" + cidade + ", estado=" + estado + "]";
	}





}
