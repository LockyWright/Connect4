// Subclass of player for the HumanPlayer, includes logic to handle inputs
import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in); 

    public HumanPlayer(Cell token){
        super(token);
    }

    @Override
    public int pickColumn(Board board) throws InputMismatchException{
        System.out.print("Choose a column between 1 and 7: ");
        while (true) { // Runs forever until valid exit condition (valid human player input) is met
            try{
                int column = scanner.nextInt();
                column = column - 1; // Convert human player input back to correct Column index
                if (board.isValidMove(column)){
                    return column;
                }
                System.out.println("Invalid move: Move wasn't a valid column, or column was full. Please try again");
                board.printBoard(); // Reprints board for readability, in case of multiple invalid inputs
            } 
            catch(InputMismatchException e){
                System.err.println("Error: non-numeric value entered, please try again");
                board.printBoard(); // Reprints board for readability, in case of multiple invalid inputs
                scanner.next(); // Prevents infinite loop by ensuring the next loop has fresh input
            }            
        }
    }
}