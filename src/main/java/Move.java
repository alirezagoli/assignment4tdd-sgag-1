public class Move {

    private final int pileIndex;
    private final int numStone;

    /**
     *  Move class represent a move by a player during the game
     * @param pileIndex represents the index of a pile selected by the player
     * @param numStone represents the number of stone player want to remove from a pile
     */
    public Move(int pileIndex, int numStone) {
        this.pileIndex = pileIndex;
        this.numStone = numStone;
    }

    public int getPileIndex() {
        return pileIndex;
    }

    public int getNumStone() {
        return numStone;
    }
}
