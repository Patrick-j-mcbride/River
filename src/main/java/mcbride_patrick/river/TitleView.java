package mcbride_patrick.river;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TitleView extends Button {
    private Tile tile;
    private VBox vBox;
    public TitleView(Tile tile) {
        super();
        this.tile = tile;
        this.vBox = this.tile.getTileView();
        this.setGraphic(this.vBox);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }
}
