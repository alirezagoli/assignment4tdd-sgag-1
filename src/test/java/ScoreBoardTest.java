import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        scoreBoard = new ScoreBoard();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
    }

    @Test
    public void incrementWin() {
        scoreBoard.setWin(0);
        scoreBoard.incrementWin();
        assertEquals(1, scoreBoard.getWin());
    }

    @Test
    public void incrementLoss() {
        scoreBoard.setLoss(0);
        scoreBoard.incrementLoss();
        assertEquals(1, scoreBoard.getLoss());
    }

    @Test
    public void print() {
        scoreBoard.setWin(2);
        scoreBoard.setLoss(0);
        scoreBoard.print();

        String expectedOutput = String.format("---------------------------------------\n%15s %15s\n---------------------------------------\n%10s %15s\n---------------------------------------\n", "PlayerName Win", "PlayerName Loss", 2, 0);
        assertEquals(expectedOutput, outContent.toString());
    }
}