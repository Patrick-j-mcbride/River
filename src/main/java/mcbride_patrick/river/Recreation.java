package mcbride_patrick.river;

public class Recreation extends LandArea{
    public Recreation(int monthCreated) {
        this.name = "Recreation";
        this.totalRevenue = 5;
        this.totalCost = 10;
        this.ButtonLabel = "-R-";
        this.LastChange = ((monthCreated-(monthCreated%12))/12) + "-" + (monthCreated%12);
        this.monthCreated = monthCreated;
        this.Age = "0-1";
    }
}
