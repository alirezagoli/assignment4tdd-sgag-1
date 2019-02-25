public class Game {

    private String playerName;


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
       return false;
    }

    int getNumPileFromPlayer(){
        return 9;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
