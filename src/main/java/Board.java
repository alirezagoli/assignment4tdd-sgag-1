import java.util.Random;

public class Board {

    private int[] piles; // Array representing the piles on the board

    public Board(int numPiles) {
        piles = new int[numPiles];
    }

    /**
     * Generate a board randomly
     */
    public void generateBoard() {
        Random random = new Random();
        for (int i = 0; i < piles.length; i++) {
            int numStone = random.nextInt(10) + 1;
            piles[i] = numStone;
        }
    }

    public void print() {

    }

    public int[] getPiles() {
        return piles;
    }

    public void setPiles(int[] piles) {
        this.piles = piles;
    }
}
