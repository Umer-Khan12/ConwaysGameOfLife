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
     * analysis: Worst case time complexity is O(8n^2) = O(n^2).
     */
    public void update(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                // create an integer array of neighbours with either 0 or 1
                int[] neighbours = getNeighbours(i, j);
                // sum the array (This represents the number of alive neighbours)
                int sum = arraySum(neighbours);
                // Rule1 does not need to be accounted for since that does not change the board
                // Rule2:
                if (board[i][j] == dead && sum == 3){
                    board[i][j] = alive;
                }
                // Rule3:
                else{
                    board[i][j] = dead;
                }
            }
        }
    }

    /**
     * Sums the contents of an integer array and returns the answer as an integer
     * @param arr the array to be summed
     */
    public int arraySum(int[] arr){
        int sum = 0;
        for (int i=0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
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
                neighbours[0] = convertToInt(board[i-1][j]);
                neighbours[1] = convertToInt(board[i-1][j+1]);
                neighbours[2] = convertToInt(board[i][j+1]);
                return neighbours;
            }
            // If the cell is in the bottom right
            else if (j == board[i].length - 1){
                neighbours[0] = convertToInt(board[i][j-1]);
                neighbours[1] = convertToInt(board[i-1][j]);
                neighbours[2] = convertToInt(board[i-1][j-1]);
                return neighbours;
            }
            // If the cell is in the middle of the bottom row
            else{
                neighbours[0] = convertToInt(board[i][j-1]);
                neighbours[1] = convertToInt(board[i][j+1]);
                neighbours[2] = convertToInt(board[i-1][j-1]);
                neighbours[3] = convertToInt(board[i-1][j]);
                neighbours[4] = convertToInt(board[i-1][j+1]);
                return neighbours;
            }
        }
        // If the cell is in the left column
        // Ignore tl, tr, bl, br cases since those are covered above
        if (j==0 && i != 0 && i != board.length - 1){
            neighbours[0] = convertToInt(board[i-1][j]);
            neighbours[1] = convertToInt(board[i-1][j+1]);
            neighbours[2] = convertToInt(board[i][j+1]);
            neighbours[3] = convertToInt(board[i+1][j+1]);
            neighbours[4] = convertToInt(board[i+1][j]);
            return neighbours;
        }
        // If the cell is in the right column
        if (j == board[i].length-1 && i != 0 && i != board.length - 1){
            neighbours[0] = convertToInt(board[i-1][j]);
            neighbours[1] = convertToInt(board[i-1][j-1]);
            neighbours[2] = convertToInt(board[i][j-1]);
            neighbours[3] = convertToInt(board[i+1][j-1]);
            neighbours[4] = convertToInt(board[i+1][j]);
            return neighbours;
        }
        // If the cell has all 8 possible neighbours
        else{
            neighbours[0] = convertToInt(board[i-1][j-1]);
            neighbours[1] = convertToInt(board[i-1][j]);
            neighbours[2] = convertToInt(board[i-1][j+1]);
            neighbours[3] = convertToInt(board[i][j-1]);
            neighbours[4] = convertToInt(board[i][j+1]);
            neighbours[5] = convertToInt(board[i+1][j-1]);
            neighbours[6] = convertToInt(board[i+1][j]);
            neighbours[7] = convertToInt(board[i+1][j+1]);
            return neighbours;
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
