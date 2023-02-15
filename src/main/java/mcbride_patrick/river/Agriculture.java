package mcbride_patrick.river;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Agriculture extends LandArea{
    public Agriculture(int monthCreated) {
        this.name = "Agriculture";
        this.totalRevenue = 0;
        this.totalCost = 300;
        this.ButtonLabel = "-A-";
        if (monthCreated/12 == 0) {
            this.LastChange = ("0-" + (monthCreated%12));
        } else {
            this.LastChange = ((monthCreated/12)-(monthCreated%12)) + "-" + (monthCreated%12);
        }
        this.Age = "0-1";
        this.MonthCreated = monthCreated;
        this.month = monthCreated;
        this.cost = 300;
    }

    public int nextMonth() {
        this.cost = 0;
        this.revenue = 0;
        this.month++;
        this.Age = ((((this.month-this.MonthCreated+1) - ((this.month-this.MonthCreated+1)%12))/12) + "-" + ((this.month-this.MonthCreated+1)%12));
        if ((this.month%12) == 5) {
            this.totalCost += 50;
            this.cost = 50;
            return -50;
        }
        if (((this.month%12) == 10)&&(this.month-this.MonthCreated > 3)) {
            this.totalRevenue += 65;
            this.revenue = 65;
            return 65;
        }
        return 0;
    }

    public VBox getTileView() {
        if ((this.month%12) == 5) {
            this.cost = 50;
        }
        if (((this.month%12) == 10)&&(this.month-this.MonthCreated > 3)) {
            this.revenue = 65;
        }
        return super.getTileView();
    }
}