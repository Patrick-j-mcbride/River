package mcbride_patrick.river;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/**
 * It creates a new Pane object, clears the children of the current GridPane, sets the style of the new Pane to be blue,
 * calculates the width of the river and the width of the buttons, clears the column and row constraints, adds the new
 * column and row constraints, adds the new Pane to the GridPane, and then adds the buttons to the GridPane
 */
public class RiverSimView extends GridPane {

    private final RiverSim riverSim;
    private Pane riverPane;

    // Creating a new RiverSimView object and calling the resize method on it.
    public RiverSimView(RiverSim riverSim) {
        this.riverSim = riverSim;
        this.resize(5, 3);
    }

    /**
     * It creates a new Pane object, clears the children of the current GridPane, sets the style of the new Pane to be
     * blue, calculates the width of the river and the width of the buttons, clears the column and row constraints, adds
     * the new column and row constraints, adds the new Pane to the GridPane, and then adds the buttons to the GridPane
     *
     * @param col the number of columns in the grid
     * @param row the number of rows in the grid
     * @return Void
     */
    public Void resize(int col, int row) {
        this.riverPane = new Pane();
        this.getChildren().clear();
        this.riverPane.setStyle("-fx-background-color: blue");
        double riverWidth = (100.0 / (col * 2));
        double buttonWidth = (100.0 - riverWidth) / (col - 1);
        this.getColumnConstraints().clear();
        this.getRowConstraints().clear();
        for (int i = 0; i < col; i++) {
            ColumnConstraints col1 = new ColumnConstraints();
            if (i == (col / 2)) {
                col1.setPercentWidth(riverWidth);
            } else {
                col1.setPercentWidth(buttonWidth);
            }
            this.getColumnConstraints().add(col1);
        }
        for (int i = 0; i < row; i++) {
            RowConstraints row1 = new RowConstraints();
            row1.setPercentHeight(100.0 / row);
            this.getRowConstraints().add(row1);
        }
        this.add(this.riverPane, col / 2, 0, 1, row);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (i != (col / 2)) {
                    TileView tileView = new TileView(this.riverSim.getTile(i, j));
                    this.add(tileView, i, j);
                }
            }
        }
        return null;
    }
}
