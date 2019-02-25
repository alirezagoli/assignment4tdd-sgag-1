import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;


public class BoardTest {

    private Board board;
    private int num;
    private int[] p;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        num = 3;

        board = new Board(3);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void getPiles() {
        board.setP(new int[]{0, 0, 0});
        assertArrayEquals(new int[]{0, 0, 0}, board.getP());

        board.setP(new int[]{1, 4, 0});
        assertArrayEquals(new int[]{1, 4, 0}, board.getP());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
