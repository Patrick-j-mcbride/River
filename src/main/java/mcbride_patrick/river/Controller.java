package mcbride_patrick.river;


public class Controller {

    private RiverSim riverSim;
    private Boolean AddCheckBoxState = false;

    public Controller(RiverSim riverSim) {
        this.riverSim = riverSim;
    }

    public void add(Boolean state) {
        this.AddCheckBoxState = state;
        System.out.println(state);
    }


    public RiverSim getRiverSim() {
        return this.riverSim;
    }

    public void resize(int col, int row) {
        return;
    }
}
