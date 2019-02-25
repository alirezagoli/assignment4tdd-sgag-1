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

    public boolean start() {

    }

    public Move getHumanMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("It's " + playerName + "'s turn. Which pile do you want to choose?");
            String numPileStr = scanner.nextLine();
            if (isInteger(numPileStr)) {
                int numPile = Integer.parseInt(numPileStr);
                System.out.println("How many stone do you want to remove?");
                String numStoneStr = scanner.nextLine();
                if (isInteger(numStoneStr)) {
                    int numStone = Integer.parseInt(numStoneStr);
                    return new Move(numPile - 1, numStone);
                } else {
                    System.out.println("Not a valid input! Please try again.\n");
                }
            } else {
                System.out.println("Not a valid input! Please try again.\n");
            }
        }
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
