package mcbride_patrick.river;


public class Controller {

    private final Layout Layout;
    private RiverSim riverSim;
    private Boolean AddCheckBoxState = false;

    public Controller(RiverSim riverSim, Layout layout) {
        this.riverSim = riverSim;
        this.Layout = layout;
    }

    public void add(Boolean state) {
        this.AddCheckBoxState = state;
        System.out.println(state);
    }


    public void resize(int col, int row) {
        this.riverSim.resize(col, row);
        this.Layout.getRiverSimView().resize(col, row);
    }

    public void nextMonth() {
        this.riverSim.nextMonth();
        this.Layout.makeRiverInfoBar();
    }
}
