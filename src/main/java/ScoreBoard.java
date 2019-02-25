public class ScoreBoard {

    private int win;
    private int loss;

    public ScoreBoard() {
        win = 0;
    }

    public void incrementWin() {
        win = win + 1;
    }

    public void incrementLoss() {
        loss=loss+1;
    }

    public void print() {

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
