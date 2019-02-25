import java.util.Scanner;

public class Nim {

    private Board board;
    private String playerName;
    private boolean turnToPlay; // false for human, true for computer
    private ComputerPlayer computerPlayer;

    public Nim(String playerName, Board board, ComputerPlayer computerPlayer, boolean turnToPlay) {
        this.board = board;
        this.board.print();
        this.playerName = playerName;
        this.turnToPlay = turnToPlay;
        this.computerPlayer = computerPlayer;
    }

    public Move getHumanMove() {

    }

    public boolean isInteger(String s) {
        Scanner sc = new Scanner(s.trim());
        if (!sc.hasNextInt(10)) return false;
        // we know it starts with a valid int, now make sure
        // there's nothing left!
        sc.nextInt(10);
        return !sc.hasNext();
    }
}
