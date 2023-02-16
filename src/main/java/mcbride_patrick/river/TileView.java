package mcbride_patrick.river;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TileView extends Button implements PropertyChangeListener {
    private final Tile tile;
    private VBox vBox;

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
