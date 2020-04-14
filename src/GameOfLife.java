// Umer Khan 04/14/2020

/**
 * An implementation of Conway's Game of Life on the console using text
 */
public class GameOfLife {
    /*
    Rules:
        1. Any live cell with two or three live neighbours survives.
        2. Any dead cell with three live neighbors becomes a live cell.
        3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
     */
    protected char alive = '@';
    protected char dead = '.';
    protected char[][] board;

    /**
     * Constructor
     * @param board the initial board
     */
    public GameOfLife(char[][] board){
        this.board = board;
    }

    /**
     * Getter for board
     */
    public char[][] getBoard(){
        return this.board;
    }

    /**
     * Updates the board according to the 3 rules
     */
    public void update(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                int[] neighbours = getNeighbours(i, j);
            }
        }
    }

    /**
     * Returns an integer array consisting of 1's and 0's where
     * 1 represents alive and 0 represents dead neighbours
     * @param i index of row on the board
     * @param j index of row item
     */
    public int[] getNeighbours(int i, int j){
        // Initialize the array to size 8 since that is the max number of neighbours
        int[] neighbours = new int[8];

        // If the cell is in the top row
        if (i == 0){
            // If the cell is in the top left
            if (j == 0){
                neighbours[0] = convertToInt(board[i+1][j]);
                neighbours[1] = convertToInt(board[i+1][j+1]);
                neighbours[2] = convertToInt(board[i][j+1]);
                return neighbours;
            }
            // If the cell is in the top right
            else if (j == board[i].length-1){
                neighbours[0] = convertToInt(board[i][j-1]);
                neighbours[1] = convertToInt(board[i+1][j]);
                neighbours[2] = convertToInt(board[i+1][j-1]);
                return neighbours;
            }
            // If the cell is in the middle of the top row
            else{
                neighbours[0] = convertToInt(board[i][j-1]);
                neighbours[1] = convertToInt(board[i][j+1]);
                neighbours[2] = convertToInt(board[i+1][j-1]);
                neighbours[3] = convertToInt(board[i+1][j]);
                neighbours[4] = convertToInt(board[i+1][j+1]);
                return neighbours;
            }
        }
        // If the cell is in the bottom row
        if (i == board.length - 1){
            // If the cell is in the bottom left
            if (j == 0){

            }
            // If the cell is in the bottom right
            if (j == board[i].length - 1){

            }
            // If the cell is in the middle of the bottom row
            else{

            }
        }
    }

    /**
     * Converts a character from the board to either a 1 or a 0.
     * 1 representing alive 0 representing dead
     * @param c the character to convert
     */
    public int convertToInt(char c){
        if (c == alive){
            return 1;
        }
        else if (c == dead){
            return 0;
        }
        else{
            throw new RuntimeException("The given character (" + c + ") is unknown.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Define the starting board
        char[][] initialBoard =
                {
                        {'@', '.', '.', '.', '.', '.', '.', '.'},
                        {'@', '.', '@', '.', '@', '.', '.', '.'},
                        {'.', '.', '.', '@', '@', '.', '.', '.'},
                        {'.', '.', '.', '@', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'@', '@', '.', '.', '.', '.', '.', '.'},
                        {'.', '@', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'}
                };

        GameOfLife Life = new GameOfLife(initialBoard);

        // Main loop
        while (true){
            char[][] curBoard = Life.getBoard();
            // Print the board
            // for each row:
            for (int i = 0; i < curBoard.length; i++){
                // concatenate every character in the row and then print it all on one line
                String row = "";
                for (int j = 0; j < curBoard[i].length; j++){
                    row = row + curBoard[i][j] + " ";
                }
                System.out.println(row);
            }

            // Wait for some time before updating board
            Thread.sleep(2000);
            System.out.println("\n\n\n\n");
            Life.update();
        }
    }
}
