package mcbride_patrick.river;

public class Controller {

    private RiverSim riverSim;
    public Controller(RiverSim riverSim) {
        this.riverSim = riverSim;
    }
    public RiverSim getRiverSim() {
        return this.riverSim;
    }
}
