import models.Dot;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DotTest {
    private final double x = 1;
    private final double y = 1;
    private final double r = 1;
    private final String res = "test";
    private final Dot testDot = new Dot(x, y, r, res);
    private final static String className = Dot.class.getName();

    @Test
    public void test1_emptyConstructor() {
        Dot empty = new Dot();
        assertNotNull("Object was not created", empty);
        assertEquals(1d, empty.getR(), 0.001);
        assertEquals(0d, empty.getX(), 0.001);
        assertEquals(0d, empty.getY(), 0.001);
        assertEquals("ERROR", empty.getResult());
    }

    @Test
    public void test2_fullConstructor() {
        assertNotNull("Object was not created", testDot);
        assertEquals(r, testDot.getR(), 0.001 );
        assertEquals(x, testDot.getX(), 0.001);
        assertEquals(y, testDot.getY(), 0.001);
        assertEquals(res, testDot.getResult());
    }

    @Test
    public void test3_toDotString() {
        String expected = "<circle r=\"3\" cx=\"270\" cy=\"30\" class=\"1.0\" stroke=\"red\" fill=\"red\"></circle>";
        assertEquals("does not matched with expected", expected, testDot.toDotString());
    }

    @Test
    public void test4_toTrString() {
        String expected = "<tr><td>1.0</td><td>1.0</td><td>1.0</td><td>test</td></tr>";
        assertEquals("table values is incorrect", expected, testDot.toTrString());
    }
}