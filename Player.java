
public abstract class Player {

    public Mark mark;                   // The player's choice of mark
    public LargeBoard myBoard;            // The player's active large board

    // This overloaded constructor takes in and initializes the player's mark and the ultimate TTT board object
    public Player(Mark thisMark, LargeBoard thisBoard) {
        mark = thisMark;
        myBoard = thisBoard;
    }

    // Check if a certain index is still available to place mark in
    public boolean isFree(int smallRow, int smallCol, int largeRow, int largeCol, LargeBoard ultimateBoard) {
        if (ultimateBoard.getMarkFrom(largeRow, largeCol, smallRow, smallCol).getMark().equals("-")) {
            return true; // Available
        }
        else{
            return false; // Not available
        }
    }

    // The abstract method further implemented by the computer and human player classes
    public abstract int[] doMove(int[] boxBounds);
	
}
