package mcbride_patrick.river;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

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

    public Background getBackground() {
        return this.landArea.getBackground();
    }

    public Label getTileInfo() {
        return this.landArea.getTileInfo();
    }

    public String getTileType() {
        return this.landArea.getName();
    }

    public void setTileType(LandArea landArea) {
        this.landArea = landArea;
        this.pcs.firePropertyChange("setTileType", null, null);
    }

    public VBox getTileView() {
        return this.landArea.getTileView();
    }

    public int nextMonth() {
        int changeInCost = this.landArea.nextMonth();
        this.pcs.firePropertyChange("nextMonth", null, null);
        return changeInCost;
    }

}
