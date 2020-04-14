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
    protected String alive = "@";
    protected String dead = ".";
    protected String[][] grid;

    /**
     * Constructor
     * @param grid the initial grid
     */
    public GameOfLife(String[][] grid){
        this.grid = grid;
    }

    public static void main(String[] args) throws InterruptedException {
        // Main loop
        while (true){



            // Wait a second before updating board
            Thread.sleep(2000);
        }
    }
}
