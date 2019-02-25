import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GameTest {
    Game game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        game.setPlayerName("PlayerName");
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
    }

    @Test
    public void showMenu() {
        game.showMenu();
        String expectedOutput = "Please choose one of the following options PlayerName\n" +
                "1. Start new game\n" +
                "2. How to play?\n" +
                "3. Exit\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}