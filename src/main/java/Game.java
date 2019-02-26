import java.util.Scanner;

public class Game {

    private String playerName;
    private ScoreBoard scoreBoard;
    private Nim nim;

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the game of Game");
        System.out.println("What is your name?");
        game.setPlayerName(scanner.nextLine());
        game.setScoreBoard(new ScoreBoard(game.getPlayerName()));

        boolean exit = false;
        while (!exit) {

            game.showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    scanner.nextLine();
                    Board board = new Board(game.getNumPileFromPlayer());
                    board.generateBoard();
                    ComputerPlayer computerPlayer = new ComputerPlayer();
                    game.nim = new Nim(game.playerName, board, computerPlayer, false);
                    boolean winTheGame = game.nim.start();
                    System.out.println("Game is over. Here are the results so far.\n");
                    game.updateScoreboard(winTheGame);
                    game.scoreBoard.print();
                    break;
                case 2:
                    game.showHelp();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Oops! Wrong option. You need to pick a valid one. Try Again\n");
                    break;
            }
        }
    }


    void showMenu() {
        System.out.print("Please choose one of the following options " + playerName+ "\n" );
        System.out.print("1. Start new game\n");
        System.out.print("2. How to play?\n");
        System.out.print("3. Exit\n");
    }

    void showHelp() {
        System.out.print("\n\t\t\tNIM GAME\n\n");
        System.out.print("The game board consists of multiple number of piles, \nwhere each pile has a number of stone.\n");
        System.out.print("Like the following board:\n\n");
        System.out.print("\t \t \tX\n");
        System.out.print("\tX\t \tX\n");
        System.out.print("\tX\tX\tX\n");
        System.out.print("\tX\tX\tX\n");
        System.out.print("\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\u203E\n");
        System.out.print("\t1\t2\t3\n");
        System.out.print("Each player needs to make a move and remove any number of stones from one of the piles.\n");
        System.out.print("But remember you need to remove at least one stone\n");
        System.out.print("The player how has not any valid move will lose!\n\n");
    }

    public boolean isInteger(String s) {
        Scanner sc = new Scanner(s.trim());
        if (!sc.hasNextInt(10)) return false;
        // we know it starts with a valid int, now make sure
        // there's nothing left!
        sc.nextInt(10);
        return !sc.hasNext();
    }

    int getNumPileFromPlayer(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("How many piles do you like on the board? (between 2 and 9)");
            String numPileStr = scanner.nextLine();
            if (isInteger(numPileStr)) {
                int numPile = Integer.parseInt(numPileStr);
                if (numPile < 2 || numPile > 9) {
                    System.out.println("Not a valid input! Please try again.\n");
                } else {
                    return numPile;
                }

            } else {
                System.out.println("Not a valid input! Please try again.\n");
            }
        }
    }

    void updateScoreboard(boolean winTheGame) {
        if (winTheGame) {
            scoreBoard.incrementWin();
        } else {
            scoreBoard.incrementLoss();
        }
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
}
