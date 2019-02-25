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
}