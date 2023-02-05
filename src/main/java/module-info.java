module mcbride_patrick.river {
    requires javafx.controls;
    requires javafx.fxml;


    opens mcbride_patrick.river to javafx.fxml;
    exports mcbride_patrick.river;
}