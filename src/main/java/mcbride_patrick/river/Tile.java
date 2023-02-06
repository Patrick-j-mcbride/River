package mcbride_patrick.river;

public class Tile {
    private LandArea landArea;

    public Tile() {
        this.landArea = new Unused();
        setTileType(this.landArea);
    }

    public void setTileType(LandArea landArea) {
        this.landArea = landArea;
    }


    public int getTotalRevenue() {
        return this.landArea.getTotalRevenue();
    }
    public int getTotalCost() {
        return this.landArea.getTotalCost();
    }
    public String getName() {
        return this.landArea.getName();
    }

}
