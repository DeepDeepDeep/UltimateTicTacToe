import java.util.Scanner;

public class Human extends Player {

    // Overloaded constructor for the human player
    // Passes in the ultimate TTT board and the current player's choice of mark
    // Calls the super constructor to intialize the variables
    public Human(Mark playerMark, LargeBoard thisBoard) {
        super(playerMark, thisBoard);
    }
    
    // Check if there are restrictions
    private boolean areThereBounds(int[] previousMove){
        
        if(previousMove[0] == -1 && previousMove[1] == -1 && previousMove[2] == -1 && previousMove[3] == -1){
            return false;
        }
        else{
            return true;
        }
    }
    
    // This method allows the user to select an index to place a mark in
    // The method returns an array containing the user's moves
    public int[] doMove(int[] previousMove) {

        Scanner input = new Scanner(System.in);
        
        // Define variables
        int boardNum = -1;
        int largeUserRow = -1;
        int largeUserCol = -1;
        int smallUserRow = -1;
        int smallUserCol = -1;
        
        // If there are no restrictions
        if(!areThereBounds(previousMove)){
            
            do{
                // Get board number
                System.out.println("Please select a valid board: ");
                boardNum = input.nextInt()+1;

                // Get largeBoard row and col from board number
                if(boardNum == 1){
                    largeUserRow = 0;
                    largeUserCol = 0;
                }
                else if (boardNum == 2){
                    largeUserRow = 0;
                    largeUserCol = 1;
                }
                else if (boardNum == 3){
                    largeUserRow = 0;
                    largeUserCol = 2;
                }
                else if (boardNum == 4){
                    largeUserRow = 1;
                    largeUserCol = 0;
                }
                else if (boardNum == 5){
                    largeUserRow = 1;
                    largeUserCol = 1;
                }
                else if (boardNum == 6){
                    largeUserRow = 1;
                    largeUserCol = 2;
                }
                else if (boardNum == 7){
                    largeUserRow = 2;
                    largeUserCol = 0;
                }
                else if (boardNum == 8){
                    largeUserRow = 2;
                    largeUserCol = 1;
                }
                else if (boardNum == 9){
                    largeUserRow = 2;
                    largeUserCol = 2;
                }
                else {
                    System.out.println("You have selected an invalid board! Try again.");
                }
                
            } while(boardNum < 1 || boardNum > 9); // Input validation

            System.out.println("Selected Board : "+(boardNum-1) +"");
            
        }
        
        // Restrictions exist
        else{
            // Opponents small board index is user's large board index.
            largeUserRow = previousMove[2];
            largeUserCol = previousMove[3];
        }
        
        
        // Get human player's choice of square number
        System.out.println("Please select a valid square on the selected board: ");
        int selectedSquare = input.nextInt();

        while(selectedSquare < 0 || selectedSquare > 8){
            System.out.println("Invalid selection, try again. (Hint: Choose 0-8)");
            System.out.println("Please select a valid square on the selected board: ");
            selectedSquare = input.nextInt();
        }
        System.out.println("Selected Square : "+selectedSquare +"\n");

        smallUserRow = selectedSquare/3;
        smallUserCol = selectedSquare%3;


        // Put the selections in an array
        int[] myMove = {largeUserRow, largeUserCol, smallUserRow, smallUserCol};
        
        // Input validation
        while (!isFree(smallUserRow, smallUserCol, largeUserRow, largeUserCol, myBoard)) {
            System.out.println("The index you selected is already taken! Look at the board and try again.");
            
            // If there are no restrictions
            if(!areThereBounds(previousMove)){

                do{
                    // Get board number
                    System.out.println("Please select a valid board: ");
                    boardNum = input.nextInt()+1;

                    // Get largeBoard row and col from board number
                    if(boardNum == 1){
                        largeUserRow = 0;
                        largeUserCol = 0;
                    }
                    else if (boardNum == 2){
                        largeUserRow = 0;
                        largeUserCol = 1;
                    }
                    else if (boardNum == 3){
                        largeUserRow = 0;
                        largeUserCol = 2;
                    }
                    else if (boardNum == 4){
                        largeUserRow = 1;
                        largeUserCol = 0;
                    }
                    else if (boardNum == 5){
                        largeUserRow = 1;
                        largeUserCol = 1;
                    }
                    else if (boardNum == 6){
                        largeUserRow = 1;
                        largeUserCol = 2;
                    }
                    else if (boardNum == 7){
                        largeUserRow = 2;
                        largeUserCol = 0;
                    }
                    else if (boardNum == 8){
                        largeUserRow = 2;
                        largeUserCol = 1;
                    }
                    else if (boardNum == 9){
                        largeUserRow = 2;
                        largeUserCol = 2;
                    }
                    else {
                        System.out.println("You have selected an invalid board! Try again.");
                    }

                } while(boardNum < 1 || boardNum > 9); // Input validation

                System.out.println("Selected Board : "+(boardNum-1) + "");

            }

            // Restrictions exist
            else{
                // Opponents small board index is user's large board index.
                largeUserRow = previousMove[2];
                largeUserCol = previousMove[3];
            }


            // Get human player's choice of row number
            System.out.println("Please select a valid square on the selected board: ");
            selectedSquare = input.nextInt();

            while(selectedSquare < 0 || selectedSquare > 8){
                System.out.println("Invalid selection, try again. (Hint: Choose 0-8)");
                System.out.println("Please select a valid square on the selected board: ");
                selectedSquare = input.nextInt();
            }
            System.out.println("Selected Square : "+selectedSquare +"\n");

            smallUserRow = selectedSquare/3;
            smallUserCol = selectedSquare%3;
            
            // Put the selections in an array
            myMove[0] = largeUserRow;
            myMove[1] = largeUserCol;
            myMove[2] = smallUserRow;
            myMove[3] = smallUserCol;
        }
        
        // Set the mark in the valid position
        myBoard.setMarkAt(largeUserRow, largeUserCol, smallUserRow, smallUserCol, mark);
            
        // Return the array containing the human's index information
        return myMove;
    }
}
