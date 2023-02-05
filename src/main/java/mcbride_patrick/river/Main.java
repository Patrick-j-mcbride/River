package mcbride_patrick.river;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        RiverSim riverSim = new RiverSim();
        Controller controller = new Controller(riverSim);
        Layout layout = new Layout(controller, riverSim);

        Scene scene = new Scene(layout.asParent(), 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
