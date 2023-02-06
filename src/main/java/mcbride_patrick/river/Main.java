package mcbride_patrick.river;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage){
        Layout layout = new Layout(primaryStage);
    }

    public static void main(String[] args) {
        launch();
    }
}
