package mcbride_patrick.river;

public class Controller {
    private final mvcexample.HelloModel model ;

    public Controller(mvcexample.HelloModel model) {
        this.model = model ;
    }

    public void updateX(String x) {
        model.setX(convertStringToInt(x));
    }

    public void updateY(String y) {
        model.setY(convertStringToInt(y));
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
