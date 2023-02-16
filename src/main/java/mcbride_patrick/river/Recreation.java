package mcbride_patrick.river;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * This class is a subclass of LandArea that represents a recreation area
 */
public class Recreation extends LandArea {

    // This is the constructor for the Recreation class. It sets the name, total revenue, total cost, button label, last
    // change, age, month created, month, and cost.
    public Recreation(int monthCreated) {
        this.name = "Recreation";
        this.totalRevenue = 0;
        this.totalCost = 10;
        this.ButtonLabel = "-R-";
        if (monthCreated / 12 == 0) {
            this.LastChange = ("0-" + (monthCreated % 12));
        } else {
            this.LastChange = ((monthCreated / 12) - (monthCreated % 12)) + "-" + (monthCreated % 12);
        }
        this.Age = "0-1";
        this.MonthCreated = monthCreated;
        this.month = monthCreated;
        this.cost = 10;
    }

    /**
     * Create a BackgroundFill object with a color of plum, no insets, and no radius, and then create a Background object
     * with that BackgroundFill object.
     *
     * @return A Background object.
     */
    public Background getBackground() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.PLUM, null, null);
        return new Background(backgroundFill);
    }

    /**
     * If the month is divisible by 12, then the revenue is 5
     *
     * @return The tile view of the property.
     */
    public VBox getTileView() {
        if ((this.month != 0) && (this.month % 12 == 0)) {
            this.revenue = 5;
        }
        return super.getTileView();
    }

    /**
     * This function is called every month and it updates the age of the tree, the revenue, and the cost
     *
     * @return The revenue for the month.
     */
    public int nextMonth() {
        this.cost = 0;
        this.revenue = 0;
        this.month++;
        this.Age = ((((this.month - this.MonthCreated + 1) - ((this.month - this.MonthCreated + 1) % 12)) / 12) + "-" + ((this.month - this.MonthCreated + 1) % 12));
        if ((this.month != 0) && (this.month % 12 == 0)) {
            this.totalRevenue += 5;
            this.revenue = 5;
            return 5;
        }
        return 0;
    }
}
