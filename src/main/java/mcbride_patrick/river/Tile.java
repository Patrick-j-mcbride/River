package mcbride_patrick.river;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class Tile {
    private LandArea landArea;

    public Tile() {
        this.landArea = new Unused();
        setTileType(this.landArea);
    }

    public void setTileType(LandArea landArea) {
        this.landArea = landArea;
    }


    public VBox getTileView() {
        return this.landArea.getTileView();
    }

    public Label getTileInfo() {
        return this.landArea.getTileInfo();
    }

}
