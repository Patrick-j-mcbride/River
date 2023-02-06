package mcbride_patrick.river;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LandArea {
    protected int totalCost;
    protected int totalRevenue;
    protected String name;

    public LandArea() {
        this.name = "-LandArea-";
        this.totalRevenue = 0;
        this.totalCost = 0;
    }

    public VBox getTileView() {
        VBox tileView = new VBox();
        Label label1 = new Label(this.name);
        Label label2 = new Label("-$" + this.totalCost + "k");
        Label label3 = new Label("+$" + this.totalRevenue + "k");
        label1.setWrapText(true);
        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setWrapText(true);
        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setWrapText(true);
        label3.setAlignment(javafx.geometry.Pos.CENTER);
        tileView.getChildren().addAll(label1, label2, label3);
        return tileView;
    }
}
