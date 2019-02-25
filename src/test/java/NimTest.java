import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class NimTest {

    private Nim nim;
    private Board board;
    private ComputerPlayer computerPlayer;
    private String playerName;

    @Before
    public void setUp() {
        board = mock(Board.class);
        playerName = "Sara";
        computerPlayer = mock(ComputerPlayer.class);

        nim = new Nim(playerName, board, computerPlayer, false);
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