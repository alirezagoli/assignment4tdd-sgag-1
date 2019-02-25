import java.util.Random;

public class ComputerPlayer {

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
