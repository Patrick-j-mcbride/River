package mcbride_patrick.river;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;


public class Layout {
    private Controller controller;
    private RiverSimView riverSimView;
    public GridPane root;
    private RiverSim riverSim;
    private CheckBox add;
    private Button resize5X3;
    private Button resize7X5;
    private Button resize9X7;
    private Button nextMonth;
    private Pane riverInfoBar;
    
    private ToggleGroup landType;
    private VBox radioGroup;
    private VBox actionCommands;
    private HBox resizeButtons;

    public Layout(RiverSim RiverSim)
    {
        // Create the root node
        this.root = new GridPane();
        // Create the model
        this.riverSim = RiverSim;
        // Create the controller
        this.controller = new Controller(this.riverSim, this);
        // Create the view
        this.riverSimView = new RiverSimView(this.riverSim);
        // Set the model for the view
        this.riverSimView.setModel(this.riverSim);
        // Fill the root node
        makeView();
    }

    private Void makeView() {
        this.root.setAlignment(Pos.CENTER);
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

        // Add the riverSimView to the this.root node
        this.root.add(this.riverSimView, 0, 0, 1, 2);

        this.riverInfoBar = new Pane();
        makeRiverInfoBar();
        this.root.add(this.riverInfoBar, 0, 2, 2, 1);
        makeLandInfo(0, 0);
        makeActionCommands();
        return null;
    }

    public void makeRiverInfoBar() {
        this.riverInfoBar.getChildren().clear();
        Label info = this.riverSim.getRiverBarInfo();
        info.setAlignment(Pos.CENTER);
        this.riverInfoBar.getChildren().add(info);
        info.layoutXProperty().bind(this.riverInfoBar.widthProperty().divide(2)
                .subtract(info.widthProperty().divide(2)));
        info.layoutYProperty().bind(this.riverInfoBar.heightProperty().divide(2)
                .subtract(info.heightProperty().divide(2)));

    }

    private void makeLandInfo(int col, int row) {
        Pane LandInfo = new Pane();
        Label info = this.riverSim.getLandInfo(col, row);
        LandInfo.getChildren().add(info);
        info.layoutXProperty().bind(LandInfo.widthProperty().divide(2)
                .subtract(info.widthProperty().divide(2)));
        info.layoutYProperty().bind(LandInfo.heightProperty().divide(2)
                .subtract(info.heightProperty().divide(2)));
        this.root.add(LandInfo, 1, 0, 1, 1);
    }

    private void makeActionCommands() {
        this.resize5X3 = new Button("5x3");
        this.resize5X3.setOnAction(e -> this.controller.resize(5, 3));
        this.resize7X5 = new Button("7x5");
        this.resize7X5.setOnAction(e -> this.controller.resize(7, 5));
        this.resize9X7 = new Button("9x7");
        this.resize9X7.setOnAction(e -> this.controller.resize(9, 7));

        this.resizeButtons = new HBox();
        Label label = new Label("Resize: ");
        label.setMaxWidth(Double.MAX_VALUE);
        this.resizeButtons.setAlignment(Pos.BOTTOM_CENTER);
        this.resizeButtons.getChildren().addAll(label,this.resize5X3, this.resize7X5, this.resize9X7);

        this.nextMonth = new Button("Next Month");
        this.nextMonth.setOnAction(e -> this.controller.nextMonth());

        this.landType = new ToggleGroup();

        RadioButton Agriculture = new RadioButton("Agriculture");
        Agriculture.setToggleGroup(this.landType);
        RadioButton Recreation = new RadioButton("Recreation");
        Recreation.setToggleGroup(this.landType);
        RadioButton Unused = new RadioButton("Unused");
        Unused.setToggleGroup(this.landType);


        this.add = new CheckBox("Add");
        this.add.setOnAction(e -> {
            this.controller.add(this.add.isSelected());
        });


        this.radioGroup = new VBox();
        this.radioGroup.setAlignment(Pos.CENTER);
        this.radioGroup.getChildren().addAll(Agriculture, Recreation, Unused);

        this.actionCommands = new VBox();
        this.actionCommands.setAlignment(Pos.CENTER);
        this.actionCommands.getChildren().addAll(this.nextMonth, this.radioGroup, this.add, this.resizeButtons);
        
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
        gridPane.add(this.nextMonth, 0, 0, 1, 1);
        gridPane.add(this.radioGroup, 0, 1, 1, 1);
        gridPane.add(this.add, 0, 2, 1, 1);
        gridPane.add(this.resizeButtons, 0, 3, 1, 1);

        gridPane.getColumnConstraints().forEach(col -> col.setHalignment(HPos.CENTER));
        //gridPane.setPrefWidth(Double.MAX_VALUE);
        //gridPane.setPrefHeight(Double.MAX_VALUE);

        this.root.add(gridPane, 1, 1, 1, 1);
    }

    public RiverSimView getRiverSimView() {
        return this.riverSimView;
    }
}
