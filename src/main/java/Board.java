import java.util.Random;

public class Board {

    private int[] p;

    public Board(int num) {
        p = new int[num];
    }

    public void generateBoard() {
        Random random = new Random();
        for (int i = 0; i < p.length; i++) {
            int numStone = random.nextInt(10) + 1;
            p[i] = numStone;
        }
    }

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }
}
