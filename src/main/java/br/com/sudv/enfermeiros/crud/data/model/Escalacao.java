package br.com.sudv.enfermeiros.crud.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Escalacao {

    private String ala;
    private String andar;
    private String nomeEnfermeiro;
    private String coren;
    @Id
    private Long idEscala;
}
