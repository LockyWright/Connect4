// Responsible for orhcestrating the game and managing game logic (e.g., which players turn it is)
public class Game {
    private Board board;
    private Player human;
    private Player computer;
    private boolean isHumanTurn = false; // Flag which is used to alternate between the human and computer's turn

    public Game(){
        board = new Board();
        human = new HumanPlayer(Cell.HUMAN);
        computer = new ComputerPlayer(Cell.COMPUTER);
    }

    public void play(){
        newGameRules();
        goesFirst();
        playGame(board);
    }

    private void newGameRules(){
        System.out.println("Welcome to Connect 4!");
		System.out.println("There are 2 players. The human player uses the X token, and the computer uses the O token");
		System.out.println("To play, type the number of the column you want to drop your counter into"); 
		System.out.println("You win by connecting 4 counters in a row - vertically, horizontally or diagonally");
        System.out.println("Good luck!");
		System.out.println("");
    }

    private void goesFirst(){
        int i = (int) ((Math.random() * 2)); // Provides a whole number between 0 and n-1 (here, n = 2)
        if(i == 1){
            System.out.println("Human player goes first!");
            board.printBoard(); // So the human player can see the board ahead of the first columnPick
            isHumanTurn = true;
        }
        else{
            System.out.println("Computer goes first!");            
            isHumanTurn = false;
        }
    }

    private void playGame(Board board){
        if (isHumanTurn){
            Cell token = human.getToken();
            int column = human.pickColumn(board);
            board.placeToken(token, column);
            board.printBoard();
            if(WinCheck.hasWon(board)){ // hasWon is checked before isDraw in case the 42nd token is a four-in-a-row
                System.out.println("Human player has won!");
                return;
            }
            if(board.isDraw()){
                System.out.println("Board is full, the game is a draw!");
                return;
            }
            isHumanTurn = false; 
        }
        else{
            Cell token = computer.getToken();
            int column = computer.pickColumn(board);
            board.placeToken(token, column);
            board.printBoard();
            if(WinCheck.hasWon(board)){
                System.out.println("Computer has won!");
                return;
            }
            if(board.isDraw()){
                System.out.println("Board is full, the game is a draw!");
                return;
            }                
            isHumanTurn = true;
        }
        playGame(board); // Continues alternating until an end condition (win or draw) is met
    }
}