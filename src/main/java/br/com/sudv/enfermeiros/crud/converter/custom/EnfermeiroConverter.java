package br.com.sudv.enfermeiros.crud.converter.custom;

import br.com.sudv.enfermeiros.crud.data.model.Enfermeiro;
import br.com.sudv.enfermeiros.crud.data.vo.v2.EnfermeiroVOV2;
import org.springframework.stereotype.Service;

@Service
public class EnfermeiroConverter {

    public EnfermeiroVOV2 convertEntityToVO(Enfermeiro enfermeiro) {
        EnfermeiroVOV2 vo = new EnfermeiroVOV2();
        vo.setId(enfermeiro.getId());
        vo.setNome(enfermeiro.getNome());
        vo.setCoren(enfermeiro.getCoren());
        vo.setEmail(enfermeiro.getEmail());
        vo.setGenero(new String());
        return vo;
    }

    public Enfermeiro convertVOToEntity(EnfermeiroVOV2 enfermeiro) {
        Enfermeiro entity = new Enfermeiro();
        entity.setId(enfermeiro.getId());
        entity.setNome(enfermeiro.getNome());
        entity.setCoren(enfermeiro.getCoren());
        entity.setEmail(enfermeiro.getEmail());
        return entity;
    }

}
