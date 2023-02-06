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

    private Scene scene;


    public Layout(Stage primaryStage)
    {
        this.riverSim = new RiverSim();
        this.controller = new Controller(this.riverSim);
        this.root = new GridPane();
        this.riverSimView = new RiverSimView(riverSim);
        this.riverSimView.setModel(riverSim);
        this.makeView();

        this.scene = new Scene(this.root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("River Simulation");
        primaryStage.show();
    }

    private Void makeView() {
        //this.root.setGridLinesVisible(true);
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

        this.root.add(this.riverSimView, 0, 0, 1, 2);

        return null;
    }
}
