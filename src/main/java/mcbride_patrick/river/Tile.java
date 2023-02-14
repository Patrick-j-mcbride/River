package mcbride_patrick.river;

import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Tile {
    public PropertyChangeSupport pcs;
    private LandArea landArea;

    public Tile() {
        this.landArea = new Unused(1);
        this.pcs = new PropertyChangeSupport(this);
    }
    public Tile(LandArea landArea) {
        this.landArea = landArea;
        this.pcs = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void setTileType(LandArea landArea) {
        this.landArea = landArea;
        this.pcs.firePropertyChange("setTileType", null, null);
    }


    public VBox getTileView() {
        return this.landArea.getTileView();
    }

    public Label getTileInfo() {
        return this.landArea.getTileInfo();
    }

    public void nextMonth() {
        this.landArea.nextMonth();
        this.pcs.firePropertyChange("nextMonth", null, null);
    }

}
