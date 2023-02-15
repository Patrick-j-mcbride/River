package mcbride_patrick.river;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;


public class Layout {
    private final Controller controller;
    public RiverSimView riverSimView;
    public GridPane root;
    public RiverSim riverSim;
    private CheckBox add;
    private Pane riverInfoBar;
    private ToggleGroup landType;
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
        row1.setPercentHeight(7.5);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(39.5);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(39.5);
        RowConstraints row4 = new RowConstraints();
        row4.setPercentHeight(14.5);
        this.root.getRowConstraints().addAll(row1, row2, row3, row4);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(70);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(30);
        this.root.getColumnConstraints().addAll(col1, col2);

        // Add the riverSimView to the this.root node
        this.root.add(this.riverSimView, 0, 1, 1, 2);

        this.riverInfoBar = new Pane();
        makeRiverInfoBar();
        this.root.add(this.riverInfoBar, 0, 3, 2, 1);
        this.LandInfo = new Pane();
        makeLandInfo(0, 0);
        this.root.add(this.LandInfo, 1, 1, 1, 1);
        makeActionCommands();
        this.makeMenuBar();
        return null;
    }

    private void makeMenuBar(){
        MenuBar menuBar = new MenuBar();
        VBox vbox = new VBox(menuBar);
        vbox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        menuBar.setPrefWidth(Double.MAX_VALUE);
        menuBar.setMaxWidth(Double.MAX_VALUE);
        Menu resizeMenu = new Menu("Resize");
        resizeMenu.setStyle("-fx-text-fill: #555555; -fx-font-weight: bold; -fx-background-color: gray;  -fx-border-color: black; -fx-border-width: 1px;");
        MenuItem resize53 = new MenuItem("5X3");
        resize53.addEventHandler(javafx.event.ActionEvent.ACTION, e -> this.controller.resize(5, 3));
        resize53.setAccelerator(KeyCombination.keyCombination("SHORTCUT+5"));
        MenuItem resize75 = new MenuItem("7X5");
        resize75.addEventHandler(javafx.event.ActionEvent.ACTION, e -> this.controller.resize(7, 5));
        resize75.setAccelerator(KeyCombination.keyCombination("SHORTCUT+7"));
        MenuItem resize97 = new MenuItem("7X9");
        resize97.addEventHandler(javafx.event.ActionEvent.ACTION, e -> this.controller.resize(9, 7));
        resize97.setAccelerator(KeyCombination.keyCombination("SHORTCUT+9"));
        resizeMenu.getItems().addAll(resize53, resize75, resize97);
        menuBar.getMenus().addAll(resizeMenu);
        this.root.add(vbox, 0, 0, 2, 1);
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
        Button resize5X3 = new Button("5x3");
        resize5X3.setOnAction(e -> this.controller.resize(5, 3));
        Button resize7X5 = new Button("7x5");
        resize7X5.setOnAction(e -> this.controller.resize(7, 5));
        Button resize9X7 = new Button("9x7");
        resize9X7.setOnAction(e -> this.controller.resize(9, 7));

        HBox resizeButtons = new HBox();
        Label label = new Label("Resize: ");
        HBox.setHgrow(label, Priority.ALWAYS);
        label.setMaxWidth(Double.MAX_VALUE);
        resizeButtons.setAlignment(Pos.BOTTOM_CENTER);
        resizeButtons.getChildren().addAll(label, resize5X3, resize7X5, resize9X7);

        Button nextMonth = new Button("Next Month");
        nextMonth.setOnAction(e -> this.controller.nextMonth());

        this.landType = new ToggleGroup();

        RadioButton Agriculture = new RadioButton("Agriculture");
        Agriculture.setToggleGroup(this.landType);
        RadioButton Recreation = new RadioButton("Recreation");
        Agriculture.setSelected(true);
        Recreation.setToggleGroup(this.landType);
        RadioButton Unused = new RadioButton("Unused");
        Unused.setToggleGroup(this.landType);

        this.add = new CheckBox("Add");

        VBox radioGroup = new VBox();
        radioGroup.setAlignment(Pos.CENTER);
        radioGroup.getChildren().addAll(Agriculture, Recreation, Unused);

        VBox actionCommands = new VBox();
        actionCommands.setAlignment(Pos.CENTER);
        Region region1 = new Region();
        VBox.setVgrow(region1, Priority.ALWAYS);
        Region region2 = new Region();
        VBox.setVgrow(region2, Priority.ALWAYS);
        Region region3 = new Region();
        VBox.setVgrow(region3, Priority.ALWAYS);
        actionCommands.getChildren().addAll(nextMonth, region1, radioGroup, region2, this.add, region3, resizeButtons);
        this.root.add(actionCommands, 1, 2, 1, 1);
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
