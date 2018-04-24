package Tests;

import org.junit.Test;
import questions.General;
import static org.junit.Assert.assertEquals;


public class GeneralTests {

    @Test
    public void reverseTest(){
        General g = new General();
        int answer = g.reverseInt(4578);
        int expected = 8754;
        assertEquals(expected, answer);
    }

    @Test
    public void bearSteadyGeneTest(){
        General g = new General();
        int answer = g.bearSteadyGene("GAAATAAA");
        int expected = 5;
        assertEquals(expected, answer);
    }

    @Test
    public void marsExplorerTest(){
        General g = new General();
        int answer = g.marsExploration("SOSOSOSOSDSDSKWOSDOSDOASDOASDFAFJDFDOSOSOWNSOSOSNDSKDDOSOSOSJDSDSOOSOSDSDOSASSOASDSAOSOSODSDSOASDWS");
        int expected = 67;
        assertEquals(expected, answer);
    }
}
