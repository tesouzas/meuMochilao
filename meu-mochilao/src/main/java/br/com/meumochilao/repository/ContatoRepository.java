package br.com.meumochilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meumochilao.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
