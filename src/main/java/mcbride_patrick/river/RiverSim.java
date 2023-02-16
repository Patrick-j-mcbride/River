package mcbride_patrick.river;

import javafx.scene.control.Label;

/**
 * This class is used to store the information about the game board, and to update the game board
 */
public class RiverSim {
    private static int Funds = 0;
    private int Month = 1;
    private int Filled = 0;
    private int rows = 3;
    private int cols = 5;
    private Tile[][] tiles;

    // This is the constructor for the RiverSim class. It sets the Filled variable to 0 and calls the resize method.
    public RiverSim() {
        this.Filled = 0;
        this.resize(cols, rows);
    }

    /**
     * This function adds funds to the Funds variable.
     *
     * @param funds The amount of funds to add to the player's funds.
     */
    public static void addFunds(int funds) {
        Funds += funds;
    }

    /**
     * This function returns the number of columns in the grid.
     *
     * @return The number of columns in the grid.
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * This function counts the number of tiles that are not "Unused" and sets the Filled variable to that number
     */
    public void getFilledTiles() {
        int total = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.tiles[i][j].getTileType().equals("Unused")) {
                    total--;
                }
            }
        }
        this.Filled = total;
    }

    /**
     * This function returns the label that contains the information about the tile at the given row and column.
     *
     * @param col the column of the tile
     * @param row the row of the tile you want to get the info of
     * @return The label that contains the information about the tile.
     */
    public Label getLandInfo(int col, int row) {
        return this.tiles[row][col].getTileInfo();
    }

    /**
     * This function returns the month of the year
     *
     * @return The month of the date.
     */
    public int getMonth() {
        return this.Month;
    }

    /**
     * It returns a label that displays the current year, month, number of filled tiles, and funds
     *
     * @return A label with the current year, month, number of filled tiles, and funds.
     */
    public Label getRiverBarInfo() {
        this.getFilledTiles();
        return new Label("Year: " + (this.Month - (this.Month % 12)) / 12 + " Month: " + (this.Month % 12) +
                "\nFilled: " + this.Filled + "\nFunds: $" + Funds + "k");
    }

    /**
     * This function returns the number of rows in the grid.
     *
     * @return The number of rows in the grid.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * This function returns the tile at the given column and row.
     *
     * @param col The column of the tile you want to get.
     * @param row The row of the tile you want to get.
     * @return The tile at the given row and column.
     */
    public Tile getTile(int col, int row) {
        return this.tiles[row][col];
    }

    /**
     * The function nextMonth() is used to increment the month and update the funds of the player
     */
    public void nextMonth() {
        this.Month++;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Funds += this.tiles[i][j].nextMonth();
            }
        }
        if ((this.Month % 12) == 3) {
            for (int i = 0; i < this.rows; i++) {
                this.tiles[i][cols / 2 - 1].setTileType(new Flooded(3));
                this.tiles[i][(cols / 2) + 1].setTileType(new Flooded(3));
            }
        } else if ((this.Month % 12) == 4) {
            for (int i = 0; i < this.rows; i++) {
                this.tiles[i][cols / 2 - 1].setTileType(new Unused(4));
                this.tiles[i][(cols / 2) + 1].setTileType(new Unused(4));
            }
        }
        this.getFilledTiles();
    }

    /**
     * This function replaces the tile at the given row and column with a new tile of the given land type
     *
     * @param landType The type of land you want to replace the tile with.
     * @param col The column of the tile you want to replace.
     * @param row The row of the tile you want to replace.
     */
    public void replaceTile(LandArea landType, int col, int row) {
        this.tiles[row][col].setTileType(landType);
    }

    /**
     * This function resets the game board to a new size, and resets the game to the beginning
     *
     * @param col the number of columns in the grid
     * @param row the number of rows in the map
     */
    public void resize(int col, int row) {
        this.cols = col;
        this.rows = row;
        this.tiles = new Tile[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
        this.Month = 1;
        Funds = 0;
        this.getFilledTiles();
    }

}
