package br.com.sudv.enfermeiros.crud.repository;

import br.com.sudv.enfermeiros.crud.model.Ala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlaRepository extends JpaRepository<Ala, Integer> {

    public Ala findByNomeAndAndar(String nome, String andar);
}
