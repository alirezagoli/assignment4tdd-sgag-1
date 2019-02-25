import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


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
    public void generateBoard() {
        board.generateBoard();
        assertTrue(board.getP()[0] > 0 && board.getP()[0] <= 10);
        assertTrue(board.getP()[1] > 0 && board.getP()[1] <= 10);
        assertTrue(board.getP()[2] > 0 && board.getP()[2] <= 10);
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
