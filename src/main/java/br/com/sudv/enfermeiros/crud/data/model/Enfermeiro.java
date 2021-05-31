package br.com.sudv.enfermeiros.crud.data.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_enfermeiro")
@Data
@Getter
@Setter
public class Enfermeiro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 80)
    private String nome;

    @Column(nullable = false, length = 80)
    private String coren;

    @Column(nullable = false, length = 80)
    private String email;

    public Enfermeiro() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enfermeiro that = (Enfermeiro) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(coren, that.coren) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, coren, email);
    }

}
