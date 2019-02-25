import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class NimTest {

    private Nim nim;
    private Board board;
    private ComputerPlayer computerPlayer;
    private String playerName;
    private ByteArrayInputStream in;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerName = "Sara";
        computerPlayer = mock(ComputerPlayer.class);

        nim = new Nim(playerName, board, computerPlayer, false);
    }

    @Test
    public void start() {
        Nim nim1 = spy(nim);

        //Scenario 1:
        // Piles = {1, 1}
        // Human move = (0, 1)
        // Computer move = (1, 1) -> nim over.

        int[] b2 = new int[]{0, 1};

        Move t1 = new Move(0, 1);
        doReturn(t1).when(nim1).getHumanMove();
        when(board.makeMove(t1)).thenReturn(true);

        when(board.getPiles()).thenReturn(b2);
        Move t2 = new Move(1, 1);
        when(computerPlayer.play(b2)).thenReturn(t2);
        when(board.makeMove(t2)).thenReturn(true);

        when(board.gameOver()).thenReturn(false).thenReturn(false).thenReturn(true);

        assertFalse(nim1.start());

        //Scenario 2:
        // Piles = {1, 1}
        // Human move = (2, 1) -> wrong move
        // Human move = (0, 1)
        // Computer move = (1, 1) -> nim over.

        Move t3 = new Move(2, 1);
        doReturn(t3).when(nim1).getHumanMove(); // t3 = move(2, 1)
        when(board.makeMove(t3)).thenReturn(false);

        doReturn(t1).when(nim1).getHumanMove(); // t3 = move(2, 1)
        when(board.makeMove(t1)).thenReturn(true);

        when(board.getPiles()).thenReturn(b2);
        when(computerPlayer.play(b2)).thenReturn(t2);
        when(board.makeMove(t2)).thenReturn(true);

        when(board.gameOver()).thenReturn(false).thenReturn(false).thenReturn(true);

        assertFalse(nim1.start());

        //Scenario 3: Computer player move is not acceptable.
        // Pile = {1, 1}
        // Human move = (0, 1)
        // Computer move = (1, 0) -> wrong move
        // Computer move - (1, 1) -> nim over

        doReturn(t1).when(nim1).getHumanMove();
        when(board.makeMove(t1)).thenReturn(true);

        Move t4 = new Move(1, 0);
        when(board.getPiles()).thenReturn(b2);
        when(computerPlayer.play(b2)).thenReturn(t4).thenReturn(t2);
        when(board.makeMove(t4)).thenReturn(false);
        when(board.makeMove(t2)).thenReturn(true);

        when(board.gameOver()).thenReturn(false).thenReturn(false).thenReturn(true);

        assertFalse(nim1.start());

        //Scenario 4: game goes for 2 round each player
        // Pile = {2, 2, 1, 1}
        // Human move = (0, 2)
        // Computer move = (1, 2)
        // Human move = (0, 2) -> wrong
        // Human move = (2, 1)
        // Computer move = (1, 1) -> wrong move
        // Computer move - (3, 1) -> nim over
        int[] b3 = new int[]{0, 2, 1, 1};
        int[] b4 = new int[]{0, 0, 0, 1};
        Move t5 = new Move(0, 2); // Human T
        Move t6 = new Move(1, 2); // Computer T
        Move t7 = new Move(0, 2); // Human F
        Move t8 = new Move(2, 1); // Human T
        Move t9 = new Move(1, 1); // Computer F
        Move t10 = new Move(3, 1); // Computer T
        doReturn(t5).doReturn(t7).doReturn(t8).when(nim1).getHumanMove();
        when(computerPlayer.play(b3)).thenReturn(t6);
        when(computerPlayer.play(b4)).thenReturn(t9).thenReturn(t10);
        when(board.makeMove(t5)).thenReturn(true);
        when(board.makeMove(t6)).thenReturn(true);
        when(board.makeMove(t7)).thenReturn(false);
        when(board.makeMove(t8)).thenReturn(true);
        when(board.makeMove(t9)).thenReturn(false);
        when(board.makeMove(t10)).thenReturn(true);
        when(board.getPiles()).thenReturn(b3).thenReturn(b4).thenReturn(b4);
        when(board.gameOver()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(true);

        assertFalse(nim1.start());
    }

    @Test
    public void getHumanMove() {
        Nim nim1 = spy(nim);

        // Scenario 1:
        // input 1, pile index = 0
        // input 2, num stone = 1
        in = new ByteArrayInputStream("1\n1".getBytes());
        System.setIn(in);

        when(nim1.isInteger("1")).thenReturn(true);
        Move answer = nim1.getHumanMove();
        assertEquals(0, answer.getPileIndex());
        assertEquals(1, answer.getNumStone());

        // Scenario 2:
        // input 1, pile index = s -> wrong
        // input 2, pile index = 0
        // input 3, num stone = 1
        in = new ByteArrayInputStream("s\n1\n1".getBytes());
        System.setIn(in);

        when(nim1.isInteger("s")).thenReturn(false);
        when(nim1.isInteger("1")).thenReturn(true);
        answer = nim1.getHumanMove();
        assertEquals(0, answer.getPileIndex());
        assertEquals(1, answer.getNumStone());

        // Scenario 3:
        // input 1, pile index = 0
        // input 2, num stone = s -> wrong
        // input 3, num stone = 1
        in = new ByteArrayInputStream("1\ns\n1\n1".getBytes());
        System.setIn(in);

        when(nim1.isInteger("s")).thenReturn(false);
        when(nim1.isInteger("1")).thenReturn(true);
        answer = nim1.getHumanMove();
        assertEquals(0, answer.getPileIndex());
        assertEquals(1, answer.getNumStone());
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