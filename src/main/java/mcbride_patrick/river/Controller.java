package mcbride_patrick.river;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class Controller {
    private Layout Layout;
    private final RiverSim riverSim;

    public Controller(RiverSim riverSim, Layout layout) {
        this.riverSim = riverSim;
        this.Layout = layout;
        this.attachButtonHandlers();
    }

    public void resize(int col, int row) {
        this.riverSim.resize(col, row);
        this.Layout.getRiverSimView().resize(col, row);
        this.attachButtonHandlers();
    }

    public void nextMonth() {
        this.riverSim.nextMonth();
        this.Layout.makeRiverInfoBar();
    }

    private class tileClicked implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent evt) {
            LandArea landArea = new Unused(Layout.getRiverSim().getMonth());
            TileView tileView = (TileView) evt.getSource();
            int row = Layout.getRiverSimView().getRowIndex(tileView);
            int col = Layout.getRiverSimView().getColumnIndex(tileView);
            if (Layout.addChecked()) {
                String type = (Layout.getLandType());
                if (type == "Unused"){
                    landArea = new Unused(Layout.getRiverSim().getMonth());
                } else if (type == "Agriculture") {
                    landArea = new Agriculture(Layout.getRiverSim().getMonth());
                } else if (type == "Recreation") {
                    landArea = new Recreation(Layout.getRiverSim().getMonth());
                }
                Layout.riverSim.replaceTile(landArea,col, row);
            }
            Layout.makeLandInfo(col, row);
        }
    }

    private void attachButtonHandlers() {
        for (Node child : this.Layout.getRiverSimView().getChildren()) {
            if (child instanceof Button) {
                child.addEventHandler(ActionEvent.ACTION, new tileClicked());
            }
        }
    }

}
