public class Game {

    private String playerName;


    void showMenu() {
        System.out.print("Please choose one of the following options " + playerName+ "\n" );
        System.out.print("1. Start new game\n");
        System.out.print("2. How to play?\n");
        System.out.print("3. Exit\n");
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
