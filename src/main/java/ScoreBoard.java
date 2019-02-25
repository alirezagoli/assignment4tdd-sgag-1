public class ScoreBoard {

    private int win;

    public ScoreBoard() {
        win = 0;
    }

    public void incrementWin() {
        win= win+1;
    }

    public void incrementLoss() {

    }

    public void setWin(int i) {
        win=i;
    }

    public int getWin() {
        return win;
    }

    public void setLoss(int loss) {
    }

    public int getLoss() {
        return 1;
    }


}
