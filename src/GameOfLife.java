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
    protected char[][] grid;

    /**
     * Constructor
     * @param grid the initial grid
     */
    public GameOfLife(char[][] grid){
        this.grid = grid;
    }

    /**
     * Getter for grid
     */
    public char[][] getGrid(){
        return this.grid;
    }

    /**
     * Updates the grid according to the 3 rules
     */
    public void update(){

    }

    public static void main(String[] args) throws InterruptedException {
        char[][] initialGrid =
                {
                        {'@', '.', '.', '.', '.', '.', '.', '.'},
                        {'@', '.', '@', '@', '.', '@', '.', '.'},
                        {'@', '.', '.', '@', '.', '@', '@', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '@', '@', '@', '.', '.', '.'},
                        {'.', '.', '@', '@', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '@', '.'},
                        {'.', '.', '.', '.', '.', '.', '@', '.'}
                };

        GameOfLife Life = new GameOfLife(initialGrid);

        // Main loop
        while (true){
            // Print the grid
            // for each row:
            for (int i = 0; i < initialGrid.length; i++){
                // concatenate every character in the row and then print it all on one line
                String row = "";
                for (int j = 0; j < initialGrid[i].length; j++){
                    row = row + initialGrid[i][j] + " ";
                }
                System.out.println(row);
            }

            // Wait a second before updating board
            Thread.sleep(2000);
            Life.update();
        }
    }
}
