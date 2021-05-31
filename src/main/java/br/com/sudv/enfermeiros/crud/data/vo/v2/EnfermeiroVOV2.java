package br.com.sudv.enfermeiros.crud.data.vo.v2;

import br.com.sudv.enfermeiros.crud.data.vo.EnfermeiroVO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class EnfermeiroVOV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String coren;
    private String email;
    private String genero;

    public EnfermeiroVOV2() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnfermeiroVOV2 that = (EnfermeiroVOV2) o;
        return id == that.id && Objects.equals(nome, that.nome) && Objects.equals(coren, that.coren) && Objects.equals(email, that.email) && Objects.equals(genero, that.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, coren, email, genero);
    }
}
