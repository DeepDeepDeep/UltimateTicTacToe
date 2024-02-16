import java.util.Scanner;

/*
    
    Name: Deep Adusumalli
    Section: CS 2336.0W2


    Analysis: We have to make a Ultimate TicTacToe Game.

    Design: We need a Human class for human inputs, computer class for computer movies, a largeboard class for the Ultimate TTT, smallboard class for the normal tic
    tac toe games and the Game class to run the game and check its status.

*/

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Set the two player objects to null
        Player x = null;
        Player o = null;

        // Create a new ultimate TTT board
        LargeBoard ultimateBoard = new LargeBoard();

        // Welcome message
        System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");

        char userMark = 'a';

        // Prompt user for mark input
        System.out.println("Choose your mark! Type 'X' to go first or type 'O' to go second: ");
        userMark = input.next().charAt(0);

        // Input validation
        while (userMark != 'x' && userMark != 'X' && userMark != 'o' && userMark != 'O') {
            System.out.println("You've entered an invalid input! Try again.");
            System.out.println("Choose your mark! Type 'X' to go first or type 'O' to go second: ");
            userMark = input.next().charAt(0);
        }

        System.out.println("ULTIMATE TIC-TAC-TOE battle begin!");

        // If the user chose 'O' and wants a computer to be 'X'
        if ((userMark == 'o' || userMark == 'O')) {
            System.out.println("User mark is 'O' and Computer mark is 'X'\n");
            x = new Computer(new Mark("X"), ultimateBoard);
            o = new Human(new Mark("O"), ultimateBoard);
        }

        // If the user chose 'X' and wants a computer to be 'O'
        else {
            System.out.println("User mark is 'X' and Computer mark is 'O'\n");
            x = new Human(new Mark("X"), ultimateBoard);
            o = new Computer(new Mark("O"), ultimateBoard);
        }

        // Create a Game object
        Game newGame = new Game(x, o, ultimateBoard);

        // Run the game
        newGame.run();
    }
}
