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
        int maxStone = 0;
        int[] piles2 = new int[piles.length];
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > maxStone) {
                maxStone = piles[i];
            }
            piles2[i] = piles[i];
        }

        StringBuilder sb = new StringBuilder();
        System.out.println();
        for (int i = maxStone; i > 0; i--) {
            for (int j = 0; j < piles2.length; j++) {
                if (piles2[j] == i) {
                    sb.append("\tX");
                    piles2[j] = piles2[j] - 1;
                } else {
                    sb.append("\t ");
                }
            }
            System.out.println(sb.toString());
            sb.setLength(0);
        }

        for (int i = 0; i < piles.length; i++) {
            sb.append("\u203E\u203E\u203E\u203E\u203E\u203E\u203E");
        }
        System.out.println(sb.toString());
        sb.setLength(0);

        for (int i = 0; i < piles.length; i++) {
            sb.append("\t");
            sb.append((i + 1));
        }
        System.out.println(sb.toString());
        System.out.println("\n");
    }

    public int[] getPiles() {
        return piles;
    }

    public void setPiles(int[] piles) {
        this.piles = piles;
    }
}
