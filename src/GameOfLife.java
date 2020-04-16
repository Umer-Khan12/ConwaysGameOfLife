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
        // for each cell
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                // number of alive neighbours
                int aliveNeighbours = getNeighbours(i, j);
                System.out.println("Sum for i=" + i + " and j=" + j + ": " + aliveNeighbours);
            }
        }
    }

    /**
     * Returns an integer representing the number of alive neighbours
     * Analysis: O(8^2) = O(64) = O(1)
     * @param i index of row on the board
     * @param j index of row item
     */
    public int getNeighbours(int i, int j){
        int neighbours = 0;
        char currentCell = board[i][j];
        // Ignore the edges of the board and loop through the 3x3 grid within the board
        // that corresponds to the cell and its neighbours.
        if (i != 0 && i != board.length-1 && j != 0 && j != board[i].length-1){
            for (int y = i-1; y < i+2; y++){
                for (int x = j-1; x < j+2; x++){
                    // if the neighbour is an alive cell then increase the number of neighbours
                    if (board[y][x] == alive){
                        neighbours++;
                    }
                }
            }
        }
        // If the cell we were checking for neighbours is alive then we counted an extra
        // neighbour in the above loop so we should subtract 1
        if (currentCell == alive){
            neighbours -= 1;
        }
        return neighbours;
    }

    public static void main(String[] args) throws InterruptedException {
        // Define the starting board
        char[][] initialBoard =
                {
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '@', '@', '@', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'}
                };

        GameOfLife Life = new GameOfLife(initialBoard);

        // Current generation
        int gen = 1;
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
            Thread.sleep(800);
            System.out.println("\n\n\n\n\n\n\nGeneration " + gen);
            gen++;
            Life.update();
        }
    }
}
