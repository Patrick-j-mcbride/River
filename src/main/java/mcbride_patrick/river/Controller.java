package mcbride_patrick.river;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

/**
 * This class is the controller for the river simulation
 */
public class Controller {
    private final RiverSim riverSim;
    private final Layout Layout;

    // Creating a new controller object.
    public Controller(RiverSim riverSim, Layout layout) {
        this.riverSim = riverSim;
        this.Layout = layout;
    }

    /**
     * This function adds an event handler to each button in the grid
     */
    private void attachButtonHandlers() {
        for (Node child : this.Layout.getRiverSimView().getChildren()) {
            if (child instanceof Button) {
                child.addEventHandler(ActionEvent.ACTION, new tileClicked());
            }
        }
    }

    /**
     * When the user clicks the next month button, the river simulation advances one month and the river info bar is
     * updated.
     */
    public void nextMonth() {
        this.riverSim.nextMonth();
        this.Layout.makeRiverInfoBar();
    }

    /**
     * This function resizes the river simulation and the river simulation view
     *
     * @param col the number of columns in the grid
     * @param row the number of rows in the grid
     */
    public void resize(int col, int row) {
        this.riverSim.resize(col, row);
        this.Layout.getRiverSimView().resize(col, row);
        this.attachButtonHandlers();
        this.riverSim.getFilledTiles();
        this.Layout.makeRiverInfoBar();
    }

    /**
     * When a tile is clicked, it checks if the user is adding a tile, and if so, it adds the tile to the grid
     */
    private class tileClicked implements EventHandler<ActionEvent> {
        /**
         * When a tile is clicked, it checks if the user is adding a tile, and if so, it adds the tile to the grid
         *
         * @param evt The event that triggered the handler.
         */
        @Override
        public void handle(ActionEvent evt) {
            LandArea landArea = new Unused(Layout.getRiverSim().getMonth());
            TileView tileView = (TileView) evt.getSource();
            int row = GridPane.getRowIndex(tileView);
            int col = GridPane.getColumnIndex(tileView);
            if (Layout.addChecked()) {
                String type = (Layout.getLandType());
                if (type == "Unused") {
                    landArea = new Unused(Layout.getRiverSim().getMonth());
                } else if (type == "Agriculture") {
                    landArea = new Agriculture(Layout.getRiverSim().getMonth());
                    RiverSim.addFunds(-300);
                } else if (type == "Recreation") {
                    landArea = new Recreation(Layout.getRiverSim().getMonth());
                    RiverSim.addFunds(-10);
                }
                Layout.riverSim.replaceTile(landArea, col, row);
            }
            Layout.makeLandInfo(col, row);
            Layout.makeRiverInfoBar();
        }
    }

}
