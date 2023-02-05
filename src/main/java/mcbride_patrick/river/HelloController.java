package mcbride_patrick.river;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class HelloController {

    private final mvcexample.HelloModel model ;

    public HelloController(mvcexample.HelloModel model) {
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