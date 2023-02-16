package mcbride_patrick.river;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

/**
 * This class is a subclass of LandArea that represents a flooded tile
 */
public class Flooded extends LandArea {
    // This is the constructor for the Flooded class. It sets the name, total revenue, total cost, button label, last
    // change, age, month created, and month to the values passed in.
    public Flooded(int monthCreated) {
        this.name = "Flooded";
        this.totalRevenue = 0;
        this.totalCost = 0;
        this.ButtonLabel = "-F-";
        if (monthCreated / 12 == 0) {
            this.LastChange = ("0-" + (monthCreated % 12));
        } else {
            this.LastChange = ((monthCreated / 12) - (monthCreated % 12)) + "-" + (monthCreated % 12);
        }
        this.Age = "0-1";
        this.MonthCreated = monthCreated;
        this.month = monthCreated;
    }

    /**
     * Create a new BackgroundFill object with a color of Color.DODGERBLUE, no insets, and no radius, and then create a new
     * Background object with that BackgroundFill object.
     *
     * @return A Background object.
     */
    public Background getBackground() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.DODGERBLUE, null, null);
        return new Background(backgroundFill);
    }

    /**
     * This function returns a label with the name of the tile in the center.
     *
     * @return A label with the name of the tile.
     */
    public Label getTileInfo() {
        Label label = new Label(this.name);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        return label;
    }
}
