package mcbride_patrick.river;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class Controller {
    private final RiverSim riverSim;
    private final Layout Layout;

    public Controller(RiverSim riverSim, Layout layout) {
        this.riverSim = riverSim;
        this.Layout = layout;
    }

    private void attachButtonHandlers() {
        for (Node child : this.Layout.getRiverSimView().getChildren()) {
            if (child instanceof Button) {
                child.addEventHandler(ActionEvent.ACTION, new tileClicked());
            }
        }
    }

    public void nextMonth() {
        this.riverSim.nextMonth();
        this.Layout.makeRiverInfoBar();
    }

    public void resize(int col, int row) {
        this.riverSim.resize(col, row);
        this.Layout.getRiverSimView().resize(col, row);
        this.attachButtonHandlers();
        this.riverSim.getFilledTiles();
        this.Layout.makeRiverInfoBar();
    }

    private class tileClicked implements EventHandler<ActionEvent> {
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
