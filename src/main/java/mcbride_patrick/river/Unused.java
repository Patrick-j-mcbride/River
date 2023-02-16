package mcbride_patrick.river;


/**
 * The Unused class is a subclass of the LandArea class. It is used to
 * represent an unused land area
 */
public class Unused extends LandArea {

    // This is the constructor for the Unused class. It sets the name, total revenue, total cost, button label, last
    // change, age, month created, and month.
    public Unused(int monthCreated) {
        this.name = "Unused";
        this.totalRevenue = 0;
        this.totalCost = 0;
        this.ButtonLabel = "-U-";
        if (monthCreated / 12 == 0) {
            this.LastChange = ("0-" + (monthCreated % 12));
        } else {
            this.LastChange = ((monthCreated / 12) - (monthCreated % 12)) + "-" + (monthCreated % 12);
        }
        this.Age = "0-1";
        this.MonthCreated = monthCreated;
        this.month = monthCreated;
    }

}
