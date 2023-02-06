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
        this.vBox = new VBox();
        this.tile = tile;
        Label label1 = new Label(tile.getName());
        Label label2 = new Label("-$" + tile.getTotalCost() + "k");
        Label label3 = new Label("+$" + tile.getTotalRevenue() + "k");
        label1.setWrapText(true);
        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setWrapText(true);
        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setWrapText(true);
        label3.setAlignment(javafx.geometry.Pos.CENTER);
        this.vBox.getChildren().addAll(label1, label2, label3);
        this.setGraphic(vBox);
        vBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        vBox.setAlignment(javafx.geometry.Pos.CENTER);
    }
}
