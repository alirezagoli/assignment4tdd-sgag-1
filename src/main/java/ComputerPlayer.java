import java.util.Random;

public class ComputerPlayer {

    /**
     * This player plays completely randomly.
     * It will choose one of the piles and remove a random number of stones from it.
     *
     * @param piles the list of piles on the board
     * @return the tuple indicating the computer move
     */
    public Move play(int[] piles) {
        Random random = new Random();
        int selectedPile, numStone;
        while (true) {
            selectedPile = random.nextInt(piles.length);
            if (piles[selectedPile] == 0)
                continue;
            numStone = random.nextInt(piles[selectedPile]) + 1;
            break;
        }
        return new Move(selectedPile, numStone);
    }
}
