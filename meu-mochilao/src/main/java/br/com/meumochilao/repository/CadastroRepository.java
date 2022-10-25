package br.com.meumochilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meumochilao.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

}
