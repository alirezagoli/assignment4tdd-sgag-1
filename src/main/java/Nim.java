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

    /**
     * Start the game and continue it by changing the turn.
     * Also checks if the game is over.
     */
    public boolean start() {
        while (!board.gameOver()) {
            if (turnToPlay) {
                // Computer turn to play
                while (true) {
                    System.out.println("It's computer turn.");
                    Move move = computerPlayer.play(board.getPiles());
                    if (board.makeMove(move)) {
                        System.out.println("From pile " + (move.getPileIndex() + 1) + " removed " +
                                move.getNumStone() + " stone.\n");
                        board.print();
                        break;
                    } else {
                        System.out.println("Oops! Not a valid move. Please try again.");
                    }
                }
            } else {
                // Human turn to play
                while (true) {
                    Move humanMove = getHumanMove();
                    if (board.makeMove(humanMove)) {
                        board.print();
                        break;
                    }
                }
            }
            turnToPlay = !turnToPlay; //Change the player for the next move
        }
        return turnToPlay;
    }

    /**
     *  It interacts with user to get its move
     * @return The move object representing user move
     */
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
