package mcbride_patrick.river;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Flooded extends LandArea{
    public Flooded(int monthCreated) {
        this.name = "Flooded";
        this.totalRevenue = 0;
        this.totalCost = 0;
        this.ButtonLabel = "-F-";
        if (monthCreated/12 == 0) {
            this.LastChange = ("0-" + (monthCreated%12));
        } else {
            this.LastChange = ((monthCreated/12)-(monthCreated%12)) + "-" + (monthCreated%12);
        }
        this.Age = "0-1";
        this.MonthCreated = monthCreated;
        this.month = monthCreated;
    }

    public Label getTileInfo() {
        Label label = new Label(this.name);
        label.setAlignment(javafx.geometry.Pos.CENTER);
        return label;
    }

    public Background getBackground() {
        BackgroundFill backgroundFill = new BackgroundFill(Color.DODGERBLUE, null, null);
        return new Background(backgroundFill);
    }
}
