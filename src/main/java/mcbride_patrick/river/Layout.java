package mcbride_patrick.river;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;


public class Layout {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private Controller controller;
    private RiverSimView riverSimView;
    private GridPane root;
    private RiverSim riverSim;
    private CheckBox Add;
    private Button Resize5X3;
    private Button Resize7X5;
    private Button Resize9X7;

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
        row1.setPercentHeight(42);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(42);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(16);
        this.root.getRowConstraints().addAll(row1, row2, row3);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(70);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        this.root.getColumnConstraints().addAll(col1, col2);

        // Add the riverSimView to the root node
        this.root.add(this.riverSimView, 0, 0, 1, 2);

        makeRiverInfoBar();
        makeLandInfo(0, 0);
        makeActionCommands();
        return null;
    }

    private void makeRiverInfoBar() {
        Pane RiverInfoBar = new Pane();
        Label info = riverSim.getRiverBarInfo();
        RiverInfoBar.getChildren().add(info);
        info.layoutXProperty().bind(RiverInfoBar.widthProperty().divide(2)
                .subtract(info.widthProperty().divide(2)));
        info.layoutYProperty().bind(RiverInfoBar.heightProperty().divide(2)
                .subtract(info.heightProperty().divide(2)));
        this.root.add(RiverInfoBar, 0, 2, 2, 1);
    }

    private void makeLandInfo(int col, int row) {
        Pane LandInfo = new Pane();
        Label info = riverSim.getLandInfo(col, row);
        LandInfo.getChildren().add(info);
        info.layoutXProperty().bind(LandInfo.widthProperty().divide(2)
                .subtract(info.widthProperty().divide(2)));
        info.layoutYProperty().bind(LandInfo.heightProperty().divide(2)
                .subtract(info.heightProperty().divide(2)));
        this.root.add(LandInfo, 1, 0, 1, 1);
    }

    private void makeActionCommands() {
        Resize5X3 = new Button("5x3");
        this.Resize5X3.setOnAction(e -> this.controller.resize(7, 5));
        Resize7X5 = new Button("7x5");
        this.Resize7X5.setOnAction(e -> this.controller.resize(9, 7));
        Resize9X7 = new Button("9x7");
        this.Resize9X7.setOnAction(e -> this.controller.resize(5, 3));

        HBox ResizeButtons = new HBox();
        Label label = new Label("Resize: ");
        label.setMaxWidth(Double.MAX_VALUE);
        ResizeButtons.setAlignment(Pos.BOTTOM_CENTER);
        ResizeButtons.getChildren().addAll(label,Resize5X3, Resize7X5, Resize9X7);

        Button NextMonth = new Button("Next Month");
        //this.NextMonth.setOnAction(e -> this.controller.nextMonth());

        ToggleGroup LandType = new ToggleGroup();

        RadioButton Agriculture = new RadioButton("Agriculture");
        Agriculture.setToggleGroup(LandType);
        RadioButton Recreation = new RadioButton("Recreation");
        Recreation.setToggleGroup(LandType);
        RadioButton Unused = new RadioButton("Unused");
        Unused.setToggleGroup(LandType);


        this.Add = new CheckBox("Add");
        this.Add.setOnAction(e -> {
            if (this.Add.isSelected()) {
                this.controller.add(true);
            }
            else {
                this.controller.add(false);
            }
        });


        VBox RadioGroup = new VBox();
        RadioGroup.setAlignment(Pos.CENTER);
        RadioGroup.getChildren().addAll(Agriculture, Recreation, Unused);

        GridPane gridPane = new GridPane();
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(25);
        row1.setValignment(VPos.TOP);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(25);
        row2.setValignment(VPos.CENTER);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(25);
        row3.setValignment(VPos.CENTER);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(25);
        row4.setValignment(VPos.BOTTOM);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        gridPane.getColumnConstraints().addAll(col1);
        gridPane.getRowConstraints().addAll(row1, row2, row3, row4);
        gridPane.add(NextMonth, 0, 0, 1, 1);
        gridPane.add(RadioGroup, 0, 1, 1, 1);
        gridPane.add(Add, 0, 2, 1, 1);
        gridPane.add(ResizeButtons, 0, 3, 1, 1);

        gridPane.getColumnConstraints().forEach(col -> col.setHalignment(HPos.CENTER));
        //gridPane.setPrefWidth(Double.MAX_VALUE);
        //gridPane.setPrefHeight(Double.MAX_VALUE);

        this.root.add(gridPane, 1, 1, 1, 1);
    }
}
