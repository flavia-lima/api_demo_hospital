package br.com.sudv.enfermeiros.crud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_escala")
@Data
@Getter
@Setter
public class Escala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "id_ala")
    public int idAla;

    @Column(name = "id_enfermeiro")
    public int idEnfermeiro;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_enfermeiro", insertable = false, updatable = false)
    private Enfermeiro enfermeiro;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ala", insertable = false, updatable = false)
    private Ala ala;
}
