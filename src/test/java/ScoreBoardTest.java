import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @Before
    public void setUp() throws Exception {
        scoreBoard = new ScoreBoard();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void incrementWin() {
        scoreBoard.setWin(0);
        scoreBoard.incrementWin();
        assertEquals(1, scoreBoard.getWin());
    }
}