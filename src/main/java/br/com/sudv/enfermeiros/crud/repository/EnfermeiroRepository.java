package br.com.sudv.enfermeiros.crud.repository;

import br.com.sudv.enfermeiros.crud.model.Enfermeiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfermeiroRepository extends JpaRepository<Enfermeiro, Integer> {

    Enfermeiro findByCoren(String coren);

}
