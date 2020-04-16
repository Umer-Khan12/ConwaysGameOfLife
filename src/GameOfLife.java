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
    // Character that represents a live cell
    protected char alive = '@';
    // Character that represents a dead cell
    protected char dead = '.';
    // The changing board and the static board for the current generation
    protected char[][] board;
    protected char[][] currentGenerationBoard;

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
     * Analysis: O(n^2)
     */
    public void update(){
        // Create a static board of this generation so we can count the neighbours
        // O(n^2)
        currentGenerationBoard = boardClone(board);
        // for each cell
        // O(n^2)
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                int currentCell = board[i][j];
                // number of alive neighbours
                // O(1)
                int aliveNeighbours = getNeighbours(i, j);
                // Rules of life:
                if (currentCell == alive && (aliveNeighbours == 2 || aliveNeighbours == 3)){
                    board[i][j] = alive;
                }
                else if (currentCell == dead && aliveNeighbours == 3){
                    board[i][j] = alive;
                }
                else{
                    board[i][j] = dead;
                }
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
        // Ignore the edges of the board and loop through the 3x3 grid within the board
        // that corresponds to the cell and its neighbours.
        if (i != 0 && i != currentGenerationBoard.length-1 && j != 0 && j != currentGenerationBoard[i].length-1){
            for (int y = i-1; y < i+2; y++){
                for (int x = j-1; x < j+2; x++){
                    // if the neighbour is an alive cell then increase the number of neighbours
                    if (currentGenerationBoard[y][x] == alive){
                        neighbours++;
                    }
                }
            }
        }
        // If the cell we were checking for neighbours is alive then we counted an extra
        // neighbour in the above loop so we should subtract 1
        if (currentGenerationBoard[i][j] == alive){
            neighbours--;
        }
        return neighbours;
    }

    /**
     * Clones a given 2d char array
     * Analysis: O(n^2)
     * @param inputBoard char array to be cloned
     */
    public char[][] boardClone(char[][] inputBoard){
        char[][] newBoard = new char[inputBoard.length][inputBoard[0].length];
        for (int i=0; i < inputBoard.length; i++){
            for (int j=0; j < inputBoard[i].length; j++){
                newBoard[i][j] = inputBoard[i][j];
            }
        }
        return newBoard;
    }

    public static void main(String[] args) throws InterruptedException {
        // Define the starting board
        // Note: In this implementation cells on the edges of the board are ignored
        char[][] initialBoard =
                {
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '@', '@', '.', '.', '.', '.', '.', '@', '@', '@', '.', '.'},
                        {'.', '@', '@', '.', '.', '.', '.', '.', '@', '@', '@', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '@', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '@', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
                };

        GameOfLife Life = new GameOfLife(initialBoard);
        System.out.println("Initial Board:");

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
            Thread.sleep(400);
            System.out.println("\n\n\n\n\n\n\nGeneration " + gen);
            gen++;
            Life.update();
        }
    }
}
