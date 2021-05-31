package br.com.sudv.enfermeiros.crud.data.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class EnfermeiroVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String coren;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnfermeiroVO that = (EnfermeiroVO) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(coren, that.coren) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, coren, email);
    }
}
