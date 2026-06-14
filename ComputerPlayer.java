// Subclass of player for the ComputerPlayer, includes logic to randomly select a playable column
public class ComputerPlayer extends Player {
    
    public ComputerPlayer(Cell token){
        super(token);
    }

    @Override
    public int pickColumn(Board board){
        int column = (int) ((Math.random() * board.getColumns())); // Randomly picks number between 0-6
        if (board.isValidMove(column)){
            return column;
        }
        else {
            return pickColumn(board); // Retry until a valid column is selected. Safe, as the game loop asks if the board is full first (prevents infinite recursion)
        }
    }
}
