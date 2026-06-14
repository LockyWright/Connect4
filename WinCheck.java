// Stateless class, reads board state to determine if a four-in-a-row exists
public class WinCheck {

    public static boolean hasWon(Board board){
        return verticalCheck(board) || horizontalCheck(board) || diagonalCheck(board);
    }

    private static boolean verticalCheck(Board board){
        int COLUMNS = board.getColumns();
        int ROWS = board.getRows();
        for(int column = 0; column < COLUMNS; column++){
            for(int row = 0; row <= ROWS-4; row++){ // Only starts where 4 tokens can fit in a row
                Cell startCell = board.getCell(row, column);
                if(startCell != Cell.EMPTY
                    && startCell == board.getCell(row+1, column)
                    && startCell == board.getCell(row+2, column)
                    && startCell == board.getCell(row+3, column)){
                        return true;
                    }
            }
        }
        return false;    
    }

    private static boolean horizontalCheck(Board board){
        int ROWS = board.getRows();
        int COLUMNS = board.getColumns();
        for(int column = 0; column <= COLUMNS-4; column++){ // Only starts where 4 tokens can fit in a row
            for(int row = 0; row < ROWS; row++){
                Cell startCell = board.getCell(row, column);
                if(startCell != Cell.EMPTY
                    && startCell == board.getCell(row, column+1)
                    && startCell == board.getCell(row, column+2)
                    && startCell == board.getCell(row, column+3)){
                        return true;
                    }
            }
        }
        return false;    
    }

    private static boolean diagonalCheck(Board board){
        int ROWS = board.getRows();
        int COLUMNS = board.getColumns();
        for(int row = 0; row <= ROWS-4; row++){ // Only starts where 4 tokens can fit in a row
            for(int column = 0; column <= COLUMNS-4; column++){
                Cell startCell = board.getCell(row, column);
                if(startCell != Cell.EMPTY
                    && startCell == board.getCell(row+1, column+1) // Upwards to the right diagonal
                    && startCell == board.getCell(row+2, column+2)
                    && startCell == board.getCell(row+3, column+3)){
                        return true;
                    }
            }
        }
        for(int row = 0; row <= ROWS-4; row++){
            for(int column = 3; column < COLUMNS; column++){ // Column starts at 3 as 0, 1, 2 don't have enough space for 4
                Cell startCell = board.getCell(row, column);
                if(startCell != Cell.EMPTY
                    && startCell == board.getCell(row+1, column-1) // Upwards to the left diagonal
                    && startCell == board.getCell(row+2, column-2)
                    && startCell == board.getCell(row+3, column-3)){
                        return true;
                    }
            }
        }
        return false;
    }
}