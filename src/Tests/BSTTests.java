package Tests;

import org.junit.Before;
import org.junit.Test;
import tree.Tree;

import static org.junit.Assert.assertEquals;

public class BSTTests {

    private Tree t = new Tree(15);

    @Before
    public void setUp(){
        t.addNode(2);
        t.addNode(23);
        t.addNode(22);
        t.addNode(26);
        t.addNode(1);
        t.addNode(6);
        t.addNode(10);
        t.addNode(2);
    }

    @Test
    public void secondLargest(){
        int answer = t.findSecondLargest();
        int expected = 23;
        assertEquals(expected, answer);
    }

    @Test
    public void getMax(){
        int answer = t.findLargest();
        int expected = 26;
        assertEquals(expected, answer);
    }
}
