package mcbride_patrick.river;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * It's a class that represents a land area
 */
public class LandArea {
    protected int totalCost;
    protected int totalRevenue;
    protected int cost = 0;
    protected int revenue = 0;

    protected String name;
    protected String ButtonLabel;
    protected String LastChange;
    protected String Age;
    protected int MonthCreated = 0;
    protected int month = 1;

    // This is the constructor for the LandArea class. It sets the default values for the LandArea class.
    public LandArea() {
        this.name = "Land Area";
        this.totalRevenue = 0;
        this.totalCost = 0;
        this.ButtonLabel = "-L-";
        this.LastChange = "0-1";
        this.Age = "0-1";
        this.MonthCreated = 1;
    }

    /**
     * Create a new BackgroundFill object with a mintcream color, no insets, and no radius, and then create a new
     * Background object with that BackgroundFill object.
     *
     * @return A Background object.
     */
    public Background getBackground() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.MINTCREAM, null, null);
        return new Background(backgroundFill);
    }

    /**
     * This function returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * It returns a label with the tile's name, last change, age, total cost, and total revenue
     *
     * @return A label with the information of the tile.
     */
    public Label getTileInfo() {
        Label label = new Label(this.name + "\nLast changed: " + this.LastChange + "\nAge: " + this.Age +
                "\nTotal Cost: $" + this.totalCost + "k\nTotal Revenue: $" + this.totalRevenue + "k");
        label.setAlignment(javafx.geometry.Pos.CENTER);
        return label;
    }

    /**
     * It creates a VBox, adds three labels to it, and returns the VBox
     *
     * @return A VBox with the tile's information.
     */
    public VBox getTileView() {
        VBox tileView = new VBox();
        Label label1 = new Label(this.ButtonLabel);
        Label label2 = new Label("-$" + this.cost + "k");
        Label label3 = new Label("+$" + this.revenue + "k");
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

    /**
     * This function increases the month by one and then sets the age to the number of years and months since the month the
     * account was created
     *
     * @return The method is returning the value 0.
     */
    public int nextMonth() {
        this.month++;
        this.Age = ((((this.month - this.MonthCreated + 1) - ((this.month - this.MonthCreated + 1) % 12)) / 12) + "-" + ((this.month - this.MonthCreated + 1) % 12));
        return 0;
    }

}
