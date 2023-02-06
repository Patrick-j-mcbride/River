package mcbride_patrick.river;
public class LandArea {
    protected int totalCost;
    protected int totalRevenue;
    protected String name;

    public LandArea() {
        this.name = "-LandArea-";
        this.totalRevenue = 0;
        this.totalCost = 0;
    }

    public int getTotalCost() {
        return this.totalCost;
    }
    public int getTotalRevenue() {
        return this.totalRevenue;
    }
    public String getName() {
        return this.name;
    }
}
