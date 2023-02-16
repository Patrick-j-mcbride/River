package mcbride_patrick.river;

import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The Tile class is a class that represents a tile on the game board
 */
public class Tile {
    public PropertyChangeSupport pcs;
    private LandArea landArea;

    // This is the default constructor for the Tile class. It sets the landArea to a new Unused object and creates a new
    // PropertyChangeSupport object.
    public Tile() {
        this.landArea = new Unused(1);
        this.pcs = new PropertyChangeSupport(this);
    }

    // This is a constructor that takes in a LandArea object and sets the landArea variable to the given LandArea object.
    public Tile(LandArea landArea) {
        this.landArea = landArea;
        this.pcs = new PropertyChangeSupport(this);
    }

    /**
     * Add a listener to the list of listeners that will be notified when a property changes.
     *
     * @param listener The PropertyChangeListener to be added
     */
    public void addObserver(PropertyChangeListener listener) {
        // GRADING: SUBJECT
        this.pcs.addPropertyChangeListener(listener);
    }

    /**
     * Returns the background of the land area.
     *
     * @return The background of the landArea.
     */
    public Background getBackground() {
        return this.landArea.getBackground();
    }

    /**
     * Returns the tile info label for the land area.
     *
     * @return The label that displays the tile information.
     */
    public Label getTileInfo() {
        return this.landArea.getTileInfo();
    }

    /**
     * This function returns the name of the land area that the tile is on.
     *
     * @return The name of the land area.
     */
    public String getTileType() {
        return this.landArea.getName();
    }

    /**
     * This function sets the tile type of the tile to the given land area.
     *
     * @param landArea The LandArea enum that you want to set the tile to.
     */
    public void setTileType(LandArea landArea) {
        this.landArea = landArea;
        // GRADING: TRIGGER
        this.pcs.firePropertyChange("setTileType", null, null);
    }

    /**
     * This function returns the tile view of the land area.
     *
     * @return The tile view of the land area.
     */
    public VBox getTileView() {
        return this.landArea.getTileView();
    }

    /**
     * NextMonth() calls nextMonth() on the landArea object, then fires a property change event.
     *
     * @return The change in cost.
     */
    public int nextMonth() {
        int changeInCost = this.landArea.nextMonth();
        // GRADING: TRIGGER
        this.pcs.firePropertyChange("nextMonth", null, null);
        return changeInCost;
    }

}
