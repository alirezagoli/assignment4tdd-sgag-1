import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


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
    public void print() {
        board.setPiles(new int[]{3, 2, 4});
        board.print();

        String expectedOutput = "\n\t \t \tX\n\tX\t \tX\n\tX\tX\tX\n\tX\tX\tX\n\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\n\t1\t2\t3\n\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void makeMove() {
        Move move = mock(Move.class);
        piles = new int[]{3, 4, 6};
        board.setPiles(piles);

        // Scenario 1:
        // move = (1, 1) -> true
        when(move.getPileIndex()).thenReturn(1);
        when(move.getNumStone()).thenReturn(1);
        assertTrue(board.makeMove(move));

        // Scenario 2:
        // move = (0, 1) -> true
        when(move.getPileIndex()).thenReturn(0);
        when(move.getNumStone()).thenReturn(1);
        assertTrue(board.makeMove(move));

        // Scenario 3:
        // move = (0, 0) -> false
        // numStone below 1
        when(move.getPileIndex()).thenReturn(0);
        when(move.getNumStone()).thenReturn(0);
        assertFalse(board.makeMove(move));

        // Scenario 4:
        // move = (0, 7) -> false
        // numStone out of bound
        when(move.getPileIndex()).thenReturn(0);
        when(move.getNumStone()).thenReturn(7);
        assertFalse(board.makeMove(move));

        // Scenario 5:
        // move = (4, 1) -> false
        // pile index out of bound
        when(move.getPileIndex()).thenReturn(4);
        when(move.getNumStone()).thenReturn(1);
        assertFalse(board.makeMove(move));

        // Scenario 6:
        // move = (-1, 1) -> false
        // pile index out of bound
        when(move.getPileIndex()).thenReturn(-1);
        when(move.getNumStone()).thenReturn(1);
        assertFalse(board.makeMove(move));
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
