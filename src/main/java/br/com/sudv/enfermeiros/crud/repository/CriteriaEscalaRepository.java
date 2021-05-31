package br.com.sudv.enfermeiros.crud.repository;

import br.com.sudv.enfermeiros.crud.model.Escalacao;
import br.com.sudv.enfermeiros.crud.model.Escala;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

@Component
public class CriteriaEscalaRepository {
    private final EntityManager em;

    public CriteriaEscalaRepository(EntityManager em) {
        this.em = em;
    }

    public List<Escalacao> findAll(){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(Escalacao.class);
        Root<Escala> root = query.from(Escala.class);

        Join<Object, Object> ala = root.join("ala", JoinType.INNER);
        Join<Object, Object> enfermeiro = root.join("enfermeiro", JoinType.INNER);

        query.multiselect(
                ala.get("nome"),
                ala.get("andar"),
                enfermeiro.get("nome"),
                enfermeiro.get("coren"),
                root.get("id")

        );

        return em.createQuery(query).getResultList();

    }

    public List<Escalacao> findById(int idEscala){

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery query = criteriaBuilder.createQuery(Escalacao.class);
        Root<Escala> root = query.from(Escala.class);

        Join<Object, Object> ala = root.join("ala", JoinType.INNER);
        Join<Object, Object> enfermeiro = root.join("enfermeiro", JoinType.INNER);

        query.multiselect(
                ala.get("nome"),
                ala.get("andar"),
                enfermeiro.get("nome"),
                enfermeiro.get("coren"),
                root.get("id")

        );
        query.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"),idEscala)));

        return em.createQuery(query).getResultList();

    }
}
