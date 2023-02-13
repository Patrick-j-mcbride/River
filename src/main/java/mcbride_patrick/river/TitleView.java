package mcbride_patrick.river;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TitleView extends Button {
    private final Tile tile;
    private VBox vBox;

    private final int col;
    private final int row;
    public TitleView(Tile tile, int col, int row) {
        super();
        this.col = col;
        this.row = row;
        this.tile = tile;
        this.vBox = this.tile.getTileView();
        this.setGraphic(this.vBox);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.setOnAction(e -> {
            this.tile.landAreaSelected(this.col, this.row);
            this.vBox = this.tile.getTileView();
            this.setGraphic(this.vBox);
        });
    }
}
