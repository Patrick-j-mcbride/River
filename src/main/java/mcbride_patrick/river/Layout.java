package mcbride_patrick.river;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;

public class Layout {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;
    private Controller controller;
    private RiverSimView riverSimView;
    private GridPane root;
    private Pane RiverInfoBar;
    private Pane LandInfo;
    private RiverSim riverSim;

    private Button NextMonth;
    private Button Resize5X3;
    private Button Resize7X5;
    private Button Resize9X7;

    private ToggleGroup LandType;
    private RadioButton Agriculture;
    private RadioButton Recreation;
    private RadioButton Unused;

    private CheckBox Add;

    private HBox ResizeButtons;


    private VBox ActionCommands;

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
        this.RiverInfoBar = new Pane();
        Label info = riverSim.getRiverBarInfo();
        this.RiverInfoBar.getChildren().add(info);
        info.layoutXProperty().bind(RiverInfoBar.widthProperty().divide(2)
                .subtract(info.widthProperty().divide(2)));
        info.layoutYProperty().bind(RiverInfoBar.heightProperty().divide(2)
                .subtract(info.heightProperty().divide(2)));
        this.root.add(this.RiverInfoBar, 0, 2, 2, 1);
    }

    private void makeLandInfo(int col, int row) {
        this.LandInfo = new Pane();
        Label info = riverSim.getLandInfo(col, row);
        this.LandInfo.getChildren().add(info);
        info.layoutXProperty().bind(LandInfo.widthProperty().divide(2)
                .subtract(info.widthProperty().divide(2)));
        info.layoutYProperty().bind(LandInfo.heightProperty().divide(2)
                .subtract(info.heightProperty().divide(2)));
        this.root.add(this.LandInfo, 1, 0, 1, 1);
    }

    private void makeActionCommands() {
        this.Resize5X3 = new Button("5x3");
        this.Resize5X3.setAlignment(Pos.CENTER_RIGHT);
        //this.Resize5X3.setOnAction(e -> this.controller.resize(5, 3));
        this.Resize7X5 = new Button("7x5");
        this.Resize7X5.setAlignment(Pos.CENTER_RIGHT);
        //this.Resize7X5.setOnAction(e -> this.controller.resize(7, 5));
        this.Resize9X7 = new Button("9x7");
        this.Resize9X7.setAlignment(Pos.CENTER_RIGHT);
        //this.Resize9X7.setOnAction(e -> this.controller.resize(9, 7));

        this.ResizeButtons = new HBox();
        this.ResizeButtons.setFillHeight(true);
        Label label = new Label("Resize: ");
        label.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(label, Priority.ALWAYS);
        this.ResizeButtons.getChildren().addAll(label,this.Resize5X3, this.Resize7X5, this.Resize9X7);


        this.NextMonth = new Button("Next Month");
        //this.NextMonth.setOnAction(e -> this.controller.nextMonth());

        this.LandType = new ToggleGroup();
        this.Agriculture = new RadioButton("Agriculture");
        this.Agriculture.setToggleGroup(this.LandType);
        this.Recreation = new RadioButton("Recreation");
        this.Recreation.setToggleGroup(this.LandType);
        this.Unused = new RadioButton("Unused");
        this.Unused.setToggleGroup(this.LandType);


        this.Add = new CheckBox("Add");
        //this.Add.setOnAction(e -> this.controller.add());

        VBox RadioGroup = new VBox();
        RadioGroup.setAlignment(Pos.CENTER);
        RadioGroup.getChildren().addAll(this.Agriculture, this.Recreation, this.Unused);

        this.ActionCommands = new VBox();
        this.ActionCommands.getChildren().addAll(this.NextMonth, RadioGroup, this.Add, this.ResizeButtons);
        this.ActionCommands.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.ActionCommands.setAlignment(Pos.CENTER);
        this.root.add(this.ActionCommands, 1, 1, 1, 1);
    }
}
