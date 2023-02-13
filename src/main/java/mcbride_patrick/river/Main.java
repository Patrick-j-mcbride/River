package mcbride_patrick.river;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    @Override
    public void start(Stage primaryStage){
        RiverSim model = new RiverSim();
        Layout layout = new Layout(model);
        Controller ctrl = new Controller(model, layout);

        Scene scene = new Scene(layout.root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("River Simulation");
        primaryStage.show();

    }

    public static void main(String[] args)  throws IOException {
        launch();
    }
}
