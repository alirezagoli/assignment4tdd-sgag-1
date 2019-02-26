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

    /**
     * Print the board
     */
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
        System.out.print("\n");
        for (int i = maxStone; i > 0; i--) {
            for (int j = 0; j < piles2.length; j++) {
                if (piles2[j] == i) {
                    sb.append("\tX");
                    piles2[j] = piles2[j] - 1;
                } else {
                    sb.append("\t ");
                }
            }
            System.out.print(sb.toString() + "\n");
            sb.setLength(0);
        }

        for (int i = 0; i < piles.length; i++) {
            sb.append("\u203E\u203E\u203E\u203E\u203E\u203E\u203E");
        }
        System.out.print(sb.toString() + "\n");
        sb.setLength(0);

        for (int i = 0; i < piles.length; i++) {
            sb.append("\t");
            sb.append((i + 1));
        }
        System.out.print(sb.toString() + "\n");
        System.out.print("\n\n");
    }

    /**
     * @param move a tuple of pile index and number of stone removed
     * @return true if the move is possible and make that move, false otherwise
     */
    public boolean makeMove(Move move) {
        if (move.getPileIndex() < 0 || move.getPileIndex() >= piles.length) {
            System.out.println("Not a valid move! Please try again.");
            return false;
        }
        if (piles[move.getPileIndex()] < move.getNumStone() || move.getNumStone() < 1) {
            System.out.println("Not a valid move! Please try again.");
            return false;
        }
        piles[move.getPileIndex()] = piles[move.getPileIndex()] - move.getNumStone();
        return true;
    }

    /**
     * A game is over when there is no more stone left on the board in any of the piles
     *
     * @return true if the game is over, false otherwise
     */
    public boolean gameOver() {
        for (int pile : piles) {
            if (pile != 0) {
                return false;
            }
        }
        return true;
    }

    public int[] getPiles() {
        return piles;
    }

    public void setPiles(int[] piles) {
        this.piles = piles;
    }
}
