import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveTest {

    private Move move;

    @Before
    public void setUp() throws Exception {
        move = new Move(4, 5);
    }

    @Test
    public void getPileIndex() {
        assertEquals(4, move.getPileIndex());
    }
}
