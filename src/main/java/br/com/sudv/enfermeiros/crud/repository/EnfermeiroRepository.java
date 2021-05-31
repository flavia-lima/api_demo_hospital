package br.com.sudv.enfermeiros.crud.repository;

import br.com.sudv.enfermeiros.crud.data.model.Enfermeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Long> {

    Enfermeiro findByCoren(String coren);

}
