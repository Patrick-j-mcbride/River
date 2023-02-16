package mcbride_patrick.river;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This class is a JavaFX Button that displays a Tile object
 */
public class TileView extends Button implements PropertyChangeListener {
    private final Tile tile;
    private VBox vBox;

    // This is the constructor for the TileView class. It takes in a Tile object and sets the TileView's tile to the Tile
    // object passed in. It then adds the TileView as an observer to the Tile object. It then sets the TileView's vBox to
    // the Tile's vBox. It then sets the TileView's graphic to the vBox. It then sets the TileView's background to the
    // Tile's background. It then creates a border for the TileView. It then sets the TileView's border to the border
    // created. It then sets the TileView's max size to the max size of a double.
    public TileView(Tile tile) {
        super();
        this.tile = tile;
        this.tile.addObserver(this);
        this.vBox = this.tile.getTileView();
        this.setGraphic(this.vBox);
        this.setBackground(this.tile.getBackground());
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                new CornerRadii(5), BorderWidths.DEFAULT);
        Border border = new Border(borderStroke);
        this.setBorder(border);
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    /**
     * This function is called whenever a property of the tile changes. It updates the tile's view to reflect the change
     *
     * @param evt The event that was fired.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.vBox = this.tile.getTileView();
        this.setGraphic(this.vBox);
        this.setBackground(this.tile.getBackground());
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
                new CornerRadii(5), BorderWidths.DEFAULT);
        Border border = new Border(borderStroke);
        this.setBorder(border);
    }
}
