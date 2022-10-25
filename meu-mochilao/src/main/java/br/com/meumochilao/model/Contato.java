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
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String assunto;

	@Column(nullable = false)
	private String mensagem;

	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contato(Long id, String nome, String email, String assunto,
			String mensagem) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.assunto = assunto;
		this.mensagem = mensagem;
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

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assunto, email, id, mensagem, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(assunto, other.assunto) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(mensagem, other.mensagem)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", assunto=" + assunto + ", mensagem="
				+ mensagem + "]";
	}

	
}
