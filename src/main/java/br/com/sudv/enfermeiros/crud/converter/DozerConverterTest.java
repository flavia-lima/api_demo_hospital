package br.com.sudv.enfermeiros.crud.converter;

import br.com.sudv.enfermeiros.crud.converter.mocks.MockEnfermeiro;
import br.com.sudv.enfermeiros.crud.data.model.Enfermeiro;
import br.com.sudv.enfermeiros.crud.data.vo.EnfermeiroVO;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DozerConverterTest {

    MockEnfermeiro inputObject;

    @Before
    public void setUp() {
        inputObject =  new MockEnfermeiro();
    }

    @Test
    public void parseEntityToVOTest() {
        EnfermeiroVO output = DozerConverter.parseObject(inputObject.mockEntity(), EnfermeiroVO.class);

        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Nome Test0", output.getNome());
        Assert.assertEquals("Coren Test0", output.getCoren());
        Assert.assertEquals("Email Test0", output.getEmail());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<EnfermeiroVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), EnfermeiroVO.class);
        EnfermeiroVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Nome Test0", outputZero.getNome());
        Assert.assertEquals("Coren Test0", outputZero.getCoren());
        Assert.assertEquals("Email Test0", outputZero.getEmail());

        EnfermeiroVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Nome Test7", outputSeven.getNome());
        Assert.assertEquals("Coren Test7", outputSeven.getCoren());
        Assert.assertEquals("Email Test7", outputSeven.getEmail());

        EnfermeiroVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Nome Test12", outputTwelve.getNome());
        Assert.assertEquals("Coren Test12", outputTwelve.getCoren());
        Assert.assertEquals("Email Test12", outputTwelve.getEmail());
    }

    @Test
    public void parseVOToEntityTest() {
        Enfermeiro output = DozerConverter.parseObject(inputObject.mockVO(), Enfermeiro.class);

        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Nome Test0", output.getNome());
        Assert.assertEquals("Coren Test0", output.getCoren());
        Assert.assertEquals("Email Test0", output.getEmail());
    }

    @Test
    public void parseVOListToEntityListTest() {
        List<Enfermeiro> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), Enfermeiro.class);
        Enfermeiro outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Nome Test0", outputZero.getNome());
        Assert.assertEquals("Coren Test0", outputZero.getCoren());
        Assert.assertEquals("Email Test0", outputZero.getEmail());

        Enfermeiro outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Nome Test7", outputSeven.getNome());
        Assert.assertEquals("Coren Test7", outputSeven.getCoren());
        Assert.assertEquals("Email Test7", outputSeven.getEmail());

        Enfermeiro outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Nome Test12", outputTwelve.getNome());
        Assert.assertEquals("Coren Test12", outputTwelve.getCoren());
        Assert.assertEquals("Email Test12", outputTwelve.getEmail());
    }

}
