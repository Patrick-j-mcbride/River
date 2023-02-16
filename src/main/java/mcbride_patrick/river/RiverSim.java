package mcbride_patrick.river;

import javafx.scene.control.Label;

public class RiverSim {
    private static int Funds = 0;
    private int Month = 1;
    private int Filled = 0;

    private int rows = 3;
    private int cols = 5;

    private Tile[][] tiles;

    public RiverSim() {
        this.Filled = 0;
        this.resize(cols, rows);
    }

    public static void addFunds(int funds) {
        Funds += funds;
    }

    public int getCols() {
        return this.cols;
    }

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

    public Label getLandInfo(int col, int row) {
        return this.tiles[row][col].getTileInfo();
    }

    public int getMonth() {
        return this.Month;
    }

    public Label getRiverBarInfo() {
        this.getFilledTiles();
        return new Label("Year: " + (this.Month - (this.Month % 12)) / 12 + " Month: " + (this.Month % 12) +
                "\nFilled: " + this.Filled + "\nFunds: $" + Funds + "k");
    }

    public int getRows() {
        return this.rows;
    }

    public Tile getTile(int col, int row) {
        return this.tiles[row][col];
    }

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

    public void replaceTile(LandArea landType, int col, int row) {
        this.tiles[row][col].setTileType(landType);
    }

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
