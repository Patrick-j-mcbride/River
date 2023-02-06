package mcbride_patrick.river;

import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Layout {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private Controller controller;
    private RiverSimView riverSimView;
    private GridPane root;

    private RiverSim riverSim;

    public Layout(Stage primaryStage)
    {
        // Create the root node
        this.root = new GridPane();
        // Create the model
        this.riverSim = new RiverSim();
        // Create the controller
        this.controller = new Controller(this.riverSim);
        // Create the view
        this.riverSimView = new RiverSimView(riverSim);
        // Set the model for the view
        this.riverSimView.setModel(riverSim);
        // Fill the root node
        this.makeView();
        // Create the scene and show it
        Scene scene = new Scene(this.root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("River Simulation");
        primaryStage.show();
    }

    private Void makeView() {
        // Set the row and column constraints
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(45);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(45);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(10);
        this.root.getRowConstraints().addAll(row1, row2, row3);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(70);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        this.root.getColumnConstraints().addAll(col1, col2);

        // Add the riverSimView to the root node
        this.root.add(this.riverSimView, 0, 0, 1, 2);

        return null;
    }
}
