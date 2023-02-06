package mcbride_patrick.river;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private Layout layout;
    private RiverSim riverSim;
    private Controller controller;
    @Override
    public void start(Stage primaryStage){
        this.riverSim = new RiverSim();
        this.controller = new Controller(this.riverSim);
        this.layout = new Layout(this.riverSim, this.controller);
        Scene scene = new Scene(this.layout.getRoot(), WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("River Simulation");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
