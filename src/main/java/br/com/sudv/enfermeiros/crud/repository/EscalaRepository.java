package br.com.sudv.enfermeiros.crud.repository;

import br.com.sudv.enfermeiros.crud.data.model.Escala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscalaRepository extends JpaRepository<Escala, Long> {
}
