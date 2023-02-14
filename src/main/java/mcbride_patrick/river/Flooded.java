package mcbride_patrick.river;

public class Flooded extends LandArea{
    public Flooded(int monthCreated) {
        this.name = "Flooded";
        this.totalRevenue = 0;
        this.totalCost = 0;
        this.ButtonLabel = "-F-";
        this.LastChange = ((monthCreated-(monthCreated%12))/12) + "-" + (monthCreated%12);
        this.monthCreated = monthCreated;
        this.Age = "0-1";
    }
}
