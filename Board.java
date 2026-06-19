// Responsible for managing the 6x7 board state, including whether or not moves are valid
public class Board{
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private Cell[][] board;

    public Board(){
        board = new Cell[ROWS][COLUMNS];
        for(int row = 0; row < ROWS; row++){
            for(int column = 0; column < COLUMNS; column++){
                board[row][column] = Cell.EMPTY;
            }
        }
    }
    
    public Cell getCell(int row, int column){ // Grid is only reachable through getCell values, which are immutable
        return board[row][column];
    }

    public int getRows(){ 
        return ROWS; 
    }
    
    public int getColumns(){
        return COLUMNS; 
    }

    public void printBoard(){
        for(int row = 0; row < ROWS; row++){
            for(int column = 0; column < COLUMNS; column++){
                if (board[row][column] == Cell.EMPTY){
                    System.out.print("[ ]");
                }
                else if (board[row][column] == Cell.COMPUTER){
                    System.out.print("[O]"); // Chose tokens O, X for readability instead of r, y
                }
                else {
                    System.out.print("[X]");
                }                
            }
            System.out.println();
        }
        System.out.println(" 1  2  3  4  5  6  7 "); // Label for each column
        System.out.println("____________________"); // Added a break and new line for readability between turns
        System.out.println();
    }

    public void placeToken(Cell token, int column){
        if(isValidMove(column)){
            for (int row = ROWS-1; row >= 0; row--){ // ROWS-1 is the bottom row, to enable the "dropping" functionality
                if (board[row][column] == Cell.EMPTY){
                    board[row][column] = token;
                    return;    
                }
            }
        }
    }

    public boolean isValidMove(int column){
        if(column < 0 || column >= COLUMNS){ // Out of bounds check
            return false;
        }
        for (int row = 0; row < ROWS; row++){
            if (board[row][column] == Cell.EMPTY){
                return true;
            }
        }
    return false;
    }

    public boolean isDraw(){
        for(int column = 0; column < COLUMNS; column++){
            Cell currentCell = board[0][column]; // Board can only be full if the top row (0) is full
            if(currentCell == Cell.EMPTY){
                return false;
            }
        }
    return true;
    }
}