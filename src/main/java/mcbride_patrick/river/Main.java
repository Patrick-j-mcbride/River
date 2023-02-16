package mcbride_patrick.river;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main function creates a new RiverSim model, a new Layout view, and a new Controller, and then sets the scene of the
 * primaryStage to the layout's root
 */
public class Main extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    /**
     * This function is called when the program is launched, and it sets up the GUI.
     */
    public static void main(String[] args) throws IOException {
        launch();
    }

    /**
     * The start function creates a new RiverSim model, a new Layout view, and a new Controller, and then sets the scene of
     * the primaryStage to the layout's root
     *
     * @param primaryStage The stage is the window that will be displayed.
     */
    @Override
    public void start(Stage primaryStage) {
        RiverSim model = new RiverSim();
        Layout layout = new Layout(model);
        Controller ctrl = new Controller(model, layout);

        Scene scene = new Scene(layout.root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("River Simulation");
        primaryStage.show();

    }
}
