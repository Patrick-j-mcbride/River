package mcbride_patrick.river;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * This class is a subclass of LandArea that represents a tile that
 * produces revenue in October and costs money in May
 */
public class Agriculture extends LandArea {
    // This is the constructor for the Agriculture class. It sets the name, total revenue, total cost, button label, last
    // change, age, month created, month, and cost.
    public Agriculture(int monthCreated) {
        this.name = "Agriculture";
        this.totalRevenue = 0;
        this.totalCost = 300;
        this.ButtonLabel = "-A-";
        if (monthCreated / 12 == 0) {
            this.LastChange = ("0-" + (monthCreated % 12));
        } else {
            this.LastChange = ((monthCreated / 12) - (monthCreated % 12)) + "-" + (monthCreated % 12);
        }
        this.Age = "0-1";
        this.MonthCreated = monthCreated;
        this.month = monthCreated;
        this.cost = 300;
    }

    /**
     * Create a new BackgroundFill object with a color of Color.SEAGREEN, no insets, and no radius, and then create a new
     * Background object with that BackgroundFill object.
     *
     * @return A Background object.
     */
    public Background getBackground() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.SEAGREEN, null, null);
        return new Background(backgroundFill);
    }

    /**
     * If the month is May, set the cost to 50. If the month is October and the tile has been in play for more than 3
     * months, set the revenue to 65
     *
     * @return The tile view of the tile.
     */
    public VBox getTileView() {
        if ((this.month % 12) == 5) {
            this.cost = 50;
        }
        if (((this.month % 12) == 10) && (this.month - this.MonthCreated > 3)) {
            this.revenue = 65;
        }
        return super.getTileView();
    }

    /**
     * This function is called every month and it updates the age of the car, the cost and revenue of the car, and the
     * total cost and revenue of the car
     *
     * @return The revenue or cost of the month.
     */
    public int nextMonth() {
        this.cost = 0;
        this.revenue = 0;
        this.month++;
        this.Age = ((((this.month - this.MonthCreated + 1) - ((this.month - this.MonthCreated + 1) % 12)) / 12) + "-" + ((this.month - this.MonthCreated + 1) % 12));
        if ((this.month % 12) == 5) {
            this.totalCost += 50;
            this.cost = 50;
            return -50;
        }
        if (((this.month % 12) == 10) && (this.month - this.MonthCreated > 3)) {
            this.totalRevenue += 65;
            this.revenue = 65;
            return 65;
        }
        return 0;
    }
}