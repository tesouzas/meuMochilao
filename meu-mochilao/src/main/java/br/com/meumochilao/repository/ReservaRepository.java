package br.com.meumochilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meumochilao.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
