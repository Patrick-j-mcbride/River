package mcbride_patrick.river;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;

public class Layout {
    private Controller controller;
    private RiverSimView riverSimView;
    private GridPane root;
    private GridPane grid1;

    private GridPane grid2;


    public Layout(RiverSim riverSim, Controller controller)
    {
        this.root = new GridPane();
        this.controller = controller;
        this.riverSimView = new RiverSimView(riverSim);
        this.riverSimView.setModel(riverSim);
        this.makeFirstGrid();
    }

    public Pane getRoot() {
        return this.root;
    }

    private Void makeFirstGrid() {
        this.root.setGridLinesVisible(true);
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(90);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(10);
        this.root.getRowConstraints().addAll(row1, row2);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);

        this.root.getColumnConstraints().add(col1);

        this.grid1 = new GridPane();
        this.grid1.setGridLinesVisible(true);
        RowConstraints grid1Row1 = new RowConstraints();
        grid1Row1.setPercentHeight(100);
        this.grid1.getRowConstraints().add(grid1Row1);
        ColumnConstraints grid1Col1 = new ColumnConstraints();
        grid1Col1.setPercentWidth(70);
        ColumnConstraints grid1Col2 = new ColumnConstraints();
        grid1Col2.setPercentWidth(30);
        this.grid1.getColumnConstraints().addAll(grid1Col1, grid1Col2);
        this.root.add(this.grid1, 0, 0);

        this.grid2 = new GridPane();
        this.grid2.setGridLinesVisible(true);
        RowConstraints grid2Row1 = new RowConstraints();
        grid2Row1.setPercentHeight(50);
        RowConstraints grid2Row2 = new RowConstraints();
        grid2Row2.setPercentHeight(50);
        this.grid2.getRowConstraints().addAll(grid2Row1, grid2Row2);
        ColumnConstraints grid2Col1 = new ColumnConstraints();
        grid2Col1.setPercentWidth(100);
        this.grid2.getColumnConstraints().add(grid2Col1);
        this.grid1.add(this.grid2, 1, 0);

        this.grid1.add(this.riverSimView, 0, 0);

        return null;
    }
}
