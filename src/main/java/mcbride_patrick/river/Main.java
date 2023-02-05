package mcbride_patrick.river;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        mvcexample.HelloModel model = new mvcexample.HelloModel();
        HelloController controller = new HelloController(model);
        HelloView view = new HelloView(controller, model);

        Scene scene = new Scene(view.asParent(), 400, 400);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
