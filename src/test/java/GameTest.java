import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class GameTest {
    Game game;
    ScoreBoard scoreBoard = mock(ScoreBoard.class);
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        game.setPlayerName("PlayerName");
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(originalOut);
        System.setIn(originalIn);
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

    @Test
    public void showHelp() {
        game.showHelp();
        String expectedOutput = "\n" +
                "\t\t\tNIM GAME\n" +
                "\n" +
                "The game board consists of multiple number of piles, \n" +
                "where each pile has a number of stone.\n" +
                "Like the following board:\n" +
                "\n" +
                "\t \t \tX\n" +
                "\tX\t \tX\n" +
                "\tX\tX\tX\n" +
                "\tX\tX\tX\n" +
                "‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾\n" +
                "\t1\t2\t3\n" +
                "Each player needs to make a move and remove any number of stones from one of the piles.\n" +
                "But remember you need to remove at least one stone\n" +
                "The player how has not any valid move will lose!\n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void getNumPileFromPlayer() throws IOException {
        String input = "9\n";
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        assertEquals(9, game.getNumPileFromPlayer());

        input = "10\n5";
        stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        assertEquals(5, game.getNumPileFromPlayer());

        input = "bb\n2";
        stream = new ByteArrayInputStream(input.getBytes());
        System.setIn(stream);
        assertEquals(2, game.getNumPileFromPlayer());
    }

    @Test
    public void isInteger() {
        assertTrue(game.isInteger("0"));
        assertTrue(game.isInteger("5"));
        assertFalse(game.isInteger("abc"));
        assertFalse(game.isInteger("a1"));
        assertFalse(game.isInteger("1a"));
        assertFalse(game.isInteger("1a1"));
        assertFalse(game.isInteger("10 s"));
    }

    @Test
    public void updateScoreboard() {
        boolean winTheGame;

        winTheGame = true;
        game.updateScoreboard(winTheGame);
        verify(scoreBoard).incrementWin();

        winTheGame = false;
        game.updateScoreboard(winTheGame);
        verify(scoreBoard).incrementLoss();
    }
}