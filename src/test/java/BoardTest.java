import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


public class BoardTest {

    private Board board;
    private int numPiles;
    private int[] piles;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        numPiles = 3;

        board = new Board(3);

        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void generateBoard() {
        board.generateBoard();
        assertTrue(board.getPiles()[0] > 0 && board.getPiles()[0] <= 10);
        assertTrue(board.getPiles()[1] > 0 && board.getPiles()[1] <= 10);
        assertTrue(board.getPiles()[2] > 0 && board.getPiles()[2] <= 10);
    }

    @Test
    public void getPiles() {
        board.setPiles(new int[]{0, 0, 0});
        assertArrayEquals(new int[]{0, 0, 0}, board.getPiles());

        board.setPiles(new int[]{1, 4, 0});
        assertArrayEquals(new int[]{1, 4, 0}, board.getPiles());
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
