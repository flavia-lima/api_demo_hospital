package br.com.sudv.enfermeiros.crud.converter.mocks;

import br.com.sudv.enfermeiros.crud.data.model.Enfermeiro;
import br.com.sudv.enfermeiros.crud.data.vo.EnfermeiroVO;

import java.util.ArrayList;
import java.util.List;

public class MockEnfermeiro {

    public Enfermeiro mockEntity() {
        return mockEntity(0);
    }

    public EnfermeiroVO mockVO() {
        return mockVO(0);
    }

    public List<Enfermeiro> mockEntityList() {
        List<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
        for (int i = 0; i < 14; i++) {
            enfermeiros.add(mockEntity(i));
        }
        return enfermeiros;
    }

    public List<EnfermeiroVO> mockVOList() {
        List<EnfermeiroVO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }

    private Enfermeiro mockEntity(Integer number) {
        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setId(number.longValue());
        enfermeiro.setNome("Nome Test" + number);
        enfermeiro.setCoren("Coren Test" + number);
        enfermeiro.setEmail("Email Test" + number);
        return enfermeiro;
    }

    private EnfermeiroVO mockVO(Integer number) {
        EnfermeiroVO enfermeiro = new EnfermeiroVO();
        enfermeiro.setId(number.longValue());
        enfermeiro.setNome("Nome Test" + number);
        enfermeiro.setCoren("Coren Test" + number);
        enfermeiro.setEmail("Email Test" + number);
        return enfermeiro;
    }

}
