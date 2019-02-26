public class ScoreBoard {

    private int win;
    private int loss;
    private String playerName;

    public ScoreBoard(String playerName) {
        win = 0;
        loss = 0;
        this.playerName = playerName;
    }

    public void incrementWin() {
        win = win + 1;
    }

    public void incrementLoss() {
        loss=loss+1;
    }

    public void print() {
        System.out.print("---------------------------------------\n");
        System.out.printf("%15s %15s", playerName + " Win", playerName + " Loss");
        System.out.print("\n");
        System.out.print("---------------------------------------\n");
        System.out.format("%10s %15s", win, loss);
        System.out.print("\n");
        System.out.print("---------------------------------------\n");
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getWin() {
        return win;
    }

    public void setLoss(int loss) {
        this.loss = loss;
    }

    public int getLoss() {
        return loss;
    }

}
