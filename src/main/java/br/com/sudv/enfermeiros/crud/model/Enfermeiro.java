package br.com.sudv.enfermeiros.crud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tb_enfermeiro")
@Data
@Getter
@Setter
public class Enfermeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(nullable = false, length = 80)
    public String nome;

    @Column(nullable = false, length = 80)
    public String coren;

    @Column(nullable = false, length = 80)
    public String email;

}
