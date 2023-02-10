package mcbride_patrick.river;

import javafx.scene.control.Label;

public class RiverSim {
    private int Month;
    private int Funds;
    private int Filled;

    private Tile[][] tiles;

    public RiverSim() {
        this.Month = 0;
        this.Funds = 0;
        this.Filled = 0;
        this.tiles = new Tile[3][5];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                this.tiles[i][j] = new Tile();
            }
        }
    }

    public Label getRiverBarInfo() {
        return new Label("Year: " + (this.Month - (this.Month % 12))/12 + " Month: " + (this.Month % 12) +
                "\nFilled: " + this.Filled + "\nFunds: $" + this.Funds + "k");
    }

    public Tile getTile(int col, int row) {
        return this.tiles[row][col];
    }

    public Label getLandInfo(int col, int row) {
        return this.tiles[row][col].getTileInfo();
    }


}
