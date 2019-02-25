import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NimTest {

    private Nim nim;

    @Before
    public void setUp() {
        nim = new Nim();
    }

    @Test
    public void isInteger() {
        assertTrue(nim.isInteger("3"));

        assertTrue(nim.isInteger("0"));

        assertFalse(nim.isInteger("ds"));

        assertFalse(nim.isInteger(" "));

        assertFalse(nim.isInteger(","));

        assertTrue(nim.isInteger("-4"));

        assertFalse(nim.isInteger("10 s"));
    }

    @After
    public void reset() {
        System.setIn(System.in);
    }
}