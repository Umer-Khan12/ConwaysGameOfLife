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
