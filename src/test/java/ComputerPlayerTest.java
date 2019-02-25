import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerPlayerTest {

    private ComputerPlayer computerPlayer;

    @Before
    public void setUp() throws Exception {
        computerPlayer = new ComputerPlayer();
    }

    @Test
    public void play() {
        int[] piles = new int[]{2, 5};
        Move answer = computerPlayer.play(piles);
        assertTrue(answer.getPileIndex() >= 0 && answer.getPileIndex() < piles.length);
        assertTrue(answer.getNumStone() <= piles[answer.getPileIndex()] && answer.getNumStone() >= 1);
    }
}