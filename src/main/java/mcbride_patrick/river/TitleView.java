package mcbride_patrick.river;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TitleView extends Button {
    private Tile tile;
    private VBox vBox;
    public TitleView() {
        super();
    }
    public TitleView getTile() {
        return this;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        this.vBox = this.tile.getTileView();
        this.setGraphic(this.vBox);
        this.vBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.vBox.setAlignment(javafx.geometry.Pos.CENTER);
    }
}
