package mcbride_patrick.river;

public class Agriculture extends LandArea{
    public Agriculture(int monthCreated) {
        this.name = "Agriculture";
        this.totalRevenue = 0;
        this.totalCost = 300;
        this.ButtonLabel = "-A-";
        this.LastChange = ((monthCreated-(monthCreated%12))/12) + "-" + (monthCreated%12);
        this.monthCreated = monthCreated;
        this.Age = "0-1";
    }
}
