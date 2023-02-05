package mcbride_patrick.river;

public class Controller {
    private final mcbride_patrick.river.RiverSim riverSim;

    public Controller(RiverSim riverSim) {
        this.riverSim = riverSim;
    }

    public void updateX(String x) {
        riverSim.setX(convertStringToInt(x));
    }

    public void updateY(String y) {
        riverSim.setY(convertStringToInt(y));
    }

    private int convertStringToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0 ;
        }
        if ("-".equals(s)) {
            return 0 ;
        }
        return Integer.parseInt(s);
    }
}
