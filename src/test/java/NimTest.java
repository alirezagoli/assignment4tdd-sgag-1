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