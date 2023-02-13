package mcbride_patrick.river;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;


public class Layout {
    private Controller controller;
    public RiverSimView riverSimView;
    public GridPane root;
    public RiverSim riverSim;
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
    private Pane LandInfo;

    public Layout(RiverSim RiverSim) {
        // Create the root node
        this.root = new GridPane();
        // Create the model
        this.riverSim = RiverSim;
        // Create the view
        this.riverSimView = new RiverSimView(this.riverSim);
        // Create the controller
        this.controller = new Controller(this.riverSim, this);
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
        this.LandInfo = new Pane();
        makeLandInfo(0, 0);
        this.root.add(this.LandInfo, 1, 0, 1, 1);
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

    public void makeLandInfo(int col, int row) {
        this.LandInfo.getChildren().clear();
        Label info = this.riverSim.getLandInfo(col, row);
        this.LandInfo.getChildren().add(info);
        info.layoutXProperty().bind(this.LandInfo.widthProperty().divide(2)
                .subtract(info.widthProperty().divide(2)));
        info.layoutYProperty().bind(this.LandInfo.heightProperty().divide(2)
                .subtract(info.heightProperty().divide(2)));
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
        HBox.setHgrow(label, Priority.ALWAYS);
        label.setMaxWidth(Double.MAX_VALUE);
        this.resizeButtons.setAlignment(Pos.BOTTOM_CENTER);
        this.resizeButtons.getChildren().addAll(label, this.resize5X3, this.resize7X5, this.resize9X7);

        this.nextMonth = new Button("Next Month");
        this.nextMonth.setOnAction(e -> this.controller.nextMonth());

        this.landType = new ToggleGroup();

        RadioButton Agriculture = new RadioButton("Agriculture");
        Agriculture.setToggleGroup(this.landType);
        RadioButton Recreation = new RadioButton("Recreation");
        Agriculture.setSelected(true);
        Recreation.setToggleGroup(this.landType);
        RadioButton Unused = new RadioButton("Unused");
        Unused.setToggleGroup(this.landType);

        this.add = new CheckBox("Add");

        this.radioGroup = new VBox();
        this.radioGroup.setAlignment(Pos.CENTER);
        this.radioGroup.getChildren().addAll(Agriculture, Recreation, Unused);

        this.actionCommands = new VBox();
        this.actionCommands.setAlignment(Pos.CENTER);
        Region region1 = new Region();
        VBox.setVgrow(region1, Priority.ALWAYS);
        Region region2 = new Region();
        VBox.setVgrow(region2, Priority.ALWAYS);
        Region region3 = new Region();
        VBox.setVgrow(region3, Priority.ALWAYS);
        this.actionCommands.getChildren().addAll(this.nextMonth, region1, this.radioGroup, region2, this.add, region3, this.resizeButtons);
        this.root.add(actionCommands, 1, 1, 1, 1);
    }

    public RiverSimView getRiverSimView() {
        return this.riverSimView;
    }

    public Boolean addChecked() {
        return this.add.isSelected();
    }

    public String getLandType() {
        return ((RadioButton) this.landType.getSelectedToggle()).getText();
    }

    public RiverSim getRiverSim() {
        return this.riverSim;
    }
}
