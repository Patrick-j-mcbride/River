package mcbride_patrick.river;

import javafx.scene.control.Label;

public class RiverSim {
    private int Month = 1;
    private final int Funds;
    private final int Filled;

    private int rows = 3;
    private int cols = 5;

    private Tile[][] tiles;

    public RiverSim() {
        this.Funds = 0;
        this.Filled = 0;
        this.resize(cols, rows);
    }

    public int getCols() {
        return this.cols;
    }

    public int getMonth() {
        return this.Month;
    }

    public Label getRiverBarInfo() {
        return new Label("Year: " + (this.Month - (this.Month % 12))/12 + " Month: " + (this.Month % 12) +
                "\nFilled: " + this.Filled + "\nFunds: $" + this.Funds + "k");
    }

    public int getRows() {
        return this.rows;
    }

    public Tile getTile(int col, int row) {
        return this.tiles[row][col];
    }

    public Label getLandInfo(int col, int row) {
        return this.tiles[row][col].getTileInfo();
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
    }

    public void nextMonth() {
        this.Month++;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.tiles[i][j].nextMonth();
            }
        }
        if (this.Month == 3) {
            for (int i = 0; i < this.rows; i++) {
                this.tiles[i][cols/2 - 1].setTileType(new Flooded(3));
                this.tiles[i][(cols/2) + 1].setTileType(new Flooded(3));
            }
        }
        else if(this.Month == 4)
        {
            for (int i = 0; i < this.rows; i++) {
                this.tiles[i][cols/2 - 1].setTileType(new Unused(4));
                this.tiles[i][(cols/2) + 1].setTileType(new Unused(4));
            }
        }
    }

    public void replaceTile(LandArea landType, int col, int row)
    {
        this.tiles[row][col].setTileType(landType);
    }

}
