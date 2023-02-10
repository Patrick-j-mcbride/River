package mcbride_patrick.river;

import javafx.scene.layout.*;

public class RiverSimView extends GridPane {

    private RiverSim riverSim;
    private Pane riverPane;

    public RiverSimView(RiverSim riverSim) {
        this.riverSim = riverSim;
        this.resize(5, 3);
    }

    public Void setModel(RiverSim riverSim) {
        this.riverSim = riverSim;
        return null;
    }
    public Void resize(int col, int row) {
        this.riverPane = new Pane();
        this.riverPane.setStyle("-fx-background-color: blue");
        double riverWidth = (100.0/(col*2));
        double buttonWidth = (100.0 - riverWidth)/(col-1);
        this.setGridLinesVisible(true);
        this.getColumnConstraints().clear();
        this.getRowConstraints().clear();
        for (int i = 0; i < col; i++) {
            ColumnConstraints col1 = new ColumnConstraints();
            if (i == (col/2)) {
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
        this.add(this.riverPane, col/2, 0, 1, row);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (i != (col/2)) {
                    this.add(new TitleView(this.riverSim.getTile(i, j)), i, j);
                }
            }
        }
        return null;
    }

}
