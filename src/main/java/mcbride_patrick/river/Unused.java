package mcbride_patrick.river;

public class Unused extends LandArea{
    public Unused(int monthCreated) {
        this.name = "Unused";
        this.totalRevenue = 0;
        this.totalCost = 0;
        this.ButtonLabel = "-U-";
        this.LastChange = ((monthCreated-(monthCreated%12))/12) + "-" + (monthCreated%12);
        this.monthCreated = monthCreated;
        this.Age = "0-1";
    }

}
