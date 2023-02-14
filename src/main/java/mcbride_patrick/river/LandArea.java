package mcbride_patrick.river;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LandArea {
    protected int totalCost;
    protected int totalRevenue;

    protected String name;
    protected String ButtonLabel;
    protected String LastChange;
    protected String Age;

    protected int monthCreated = 1;

    protected int month = 1;

    public LandArea() {
        this.name = "Land Area";
        this.totalRevenue = 0;
        this.totalCost = 0;
        this.ButtonLabel = "-L-";
        this.LastChange = "0-1";
        this.Age = "0-1";
    }

    public Label getTileInfo() {
        Label label = new Label(this.name + "\nLast changed: " + this.LastChange + "\nAge: " + this.Age +
                "\nTotal Cost: $" + this.totalCost + "k\nTotal Revenue: $" + this.totalRevenue + "k");
        label.setAlignment(javafx.geometry.Pos.CENTER);
        return label;
    }

    public VBox getTileView() {
        VBox tileView = new VBox();
        Label label1 = new Label(this.ButtonLabel);
        Label label2 = new Label("-$" + this.totalCost + "k");
        Label label3 = new Label("+$" + this.totalRevenue + "k");
        label1.setWrapText(true);
        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setWrapText(true);
        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setWrapText(true);
        label3.setAlignment(javafx.geometry.Pos.CENTER);
        tileView.getChildren().addAll(label1, label2, label3);
        tileView.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        tileView.setAlignment(javafx.geometry.Pos.CENTER);
        return tileView;
    }

    public void nextMonth() {
        this.month++;
        this.Age = (((this.month - (this.month%12))/12) + "-" + (this.month%12));
        this.LastChange = this.Age;
    }

    public StringProperty getNameProperty() {
        return new SimpleStringProperty(this.name);
    }
}
