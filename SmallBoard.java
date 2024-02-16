

public class SmallBoard {
    
    private String winner = "-"; // - means no winner yet, F means tie, X means X won, and O means O won
    private Mark[][] normalBoard;
    
    // Constructor initializes the 3x3 small board
    public SmallBoard() {
        normalBoard = new Mark[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                normalBoard[i][j] = new Mark("-");
            }
        }
    }
    
    // Getter for the small board winner
    public String getWinner() {
        return winner;
    }

    // Setter for the small board winner
    public void setWinner(String thisWinner) {
        winner = thisWinner;
    }
    
    // Getter for mark at a specific index
    public Mark getMarkFrom(int row, int column) {
        return normalBoard[row][column];
    }

    // Setter for mark at a specific index
    public void setMarkAt(int row, int column, Mark userMark) {
        normalBoard[row][column] = userMark;
    }

    // Return row in String format
    public String printRow(int row) {
        String a=normalBoard[row][0].getMark().equals("-")?String.valueOf(row*3):normalBoard[row][0].getMark();
        String b=normalBoard[row][1].getMark().equals("-")?String.valueOf(row*3+1):normalBoard[row][1].getMark();
        String c=normalBoard[row][2].getMark().equals("-")?String.valueOf(row*3+2):normalBoard[row][2].getMark();
        return "| "+ a + " | " + b + " | " + c + " | ";
    }

}
