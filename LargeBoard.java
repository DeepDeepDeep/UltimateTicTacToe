import java.util.Iterator;

public class LargeBoard implements Iterable {

    private SmallBoard[][] ultimateBoard;

    // The LargeBoard constructor initializes a 3x3 array
    // where the elements are SmallBoard objects
    public LargeBoard() {
        ultimateBoard = new SmallBoard[3][3];
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                ultimateBoard[row][col] = new SmallBoard();
            }
        }
    }

    // Get the mark present in a specific location on the board
    public Mark getMarkFrom(int largeRow, int largeCol, int smallRow, int smallCol) {
        return ultimateBoard[largeRow][largeCol].getMarkFrom(smallRow, smallCol);
    }

    // Set the mark at a specific location on the board, using the small board setter method
    public void setMarkAt(int largeRow, int largeCol, int smallRow, int smallCol, Mark userMark) {
        ultimateBoard[largeRow][largeCol].setMarkAt(smallRow, smallCol, userMark);
    }

    // Get a specific small board
    public SmallBoard getSmallBoard(int row, int col) {
        return ultimateBoard[row][col];
    }
    
    // Return the entire ultimate TTT board row line in String format
    private String printLine(int row) {
        int R = row/3;
        return "BOARD#" + (R*3) +" "+ getSmallBoard(R, 0).printRow(row-R*3) + " BOARD#" + ((R*3)+1) +" "+ getSmallBoard(R, 1).printRow(row-R*3) + " BOARD#" + ((R*3)+2) +" "+ getSmallBoard(R, 2).printRow(row-R*3) + "\n";
    }

    // Store the board information in a string format
    public String storeBoard() {
        String s = "";
        for (int r = 0; r < 3; r++) {
            s += "   " + printLine(r);
        }
        for (int r = 3; r < 6; r++) {
            s += "   " + printLine(r);
        }
        for (int r = 6; r < 9; r++) {
            s += "   " + printLine(r);
        }
        s += "\n";
        return s;
    }

    // Override next and hasNext
    // to use iterator functionaries
    @Override
    public Iterator<SmallBoard> iterator() {
        return new Iterator<SmallBoard>() {

            private int currentIndex = 0;

            // To move along the rows of the ultimate TTT board by moving to
            // the next small board
            @Override
            public SmallBoard next() {
                return ultimateBoard[currentIndex / 3][currentIndex++ % 3];
            }

            // Check if another small board exists
            @Override
            public boolean hasNext() {
                return currentIndex < 9;
            }

        };
    }
}
