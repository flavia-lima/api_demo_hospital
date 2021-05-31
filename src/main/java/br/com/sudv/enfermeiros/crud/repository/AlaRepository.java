package br.com.sudv.enfermeiros.crud.repository;

import br.com.sudv.enfermeiros.crud.data.model.Ala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlaRepository extends JpaRepository<Ala, Long> {

    public Ala findByNomeAndAndar(String nome, String andar);
}
