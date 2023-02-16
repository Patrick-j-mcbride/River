

package mcbride_patrick.river;
/**
 * Complete the following checklist.
 * If you partially completed an item, put a note how it can be checked
 * for what is working for partial credit.
 *
 *
 * DONE - Followed the class OOP diagram
 * DONE - Observer pattern (ignores tiers)
 *
 *
 * 1.	Tier: Views and animal
 * DONE - a. All objects (ignoring the sim area)
 * DONE - b. Have a starting number of tiles in sim area
 * DONE - c. Able to add/remove a land area properly
 * DONE - d. Info bar listed correctly with all the required elements
 * DONE - e. Tile Text correct in land area
 * DONE - f. Tile Text correct for each for all rectangles
 * DONE - g. Radio buttons update properly
 * DONE - h. Selecting a rectangle without “add” updates the land area info
 *
 *
 *
 * 2a Tier: Advanced functionality
 * DONE - a. Next month button has some noticeable effect
 * DONE - b. Land areas updated properly on “next”
 * DONE - c. Sim info bar updated properly
 * DONE - d. Selecting a tile after an update shows the new information
 *
 *
 *
 * 2b: Layout
 * DONE - a. Location of all items in correct spot
 * DONE - b. Layout still correct on window resize
 * DONE - c. Resize grid at minimum resets the grid and info
 * DONE - d. Everything still working that is listed above with resize
 *
 *
 * Final Tier: Extensions 30
 * Extension 1: <2d> <10> <Land area colors>: Each land area type has its own color.
 *
 * Extension 2: <3a> <10> <hot-keys>: All three resize options have their own keybinding.
 * The OS key is the windows key or command on MacOS.
 * Resize to 5X3: OS key + 5
 * Resize to 7X5: OS key + 7
 * Resize to 9X7: OS key + 9
 *
 * Extension 3: <3b> <15> <Menu bar>: There is a drop down menu bar item called resize. There are three options: 5X3, 7X5, and 9X7 they resize the land area.
 *
 * The grade you compute is the starting point for course staff,
 * who reserve the right to change the grade if they disagree with your assessment
 * and to deduct points for other issues they may encounter, such as errors
 * in the submission process, naming issues, etc.
 */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main function creates a new RiverSim model, a new Layout view, and a new Controller, and then sets the scene of the
 * primaryStage to the layout's root
 */
public class Main extends Application {
    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    /**
     * This function is called when the program is launched, and it sets up the GUI.
     */
    public static void main(String[] args) throws IOException {
        launch();
    }

    /**
     * The start function creates a new RiverSim model, a new Layout view, and a new Controller, and then sets the scene of
     * the primaryStage to the layout's root
     *
     * @param primaryStage The stage is the window that will be displayed.
     */
    @Override
    public void start(Stage primaryStage) {
        RiverSim model = new RiverSim();
        Layout layout = new Layout(model);
        Controller ctrl = new Controller(model, layout);

        Scene scene = new Scene(layout.root, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("River Simulation");
        primaryStage.show();

    }
}
