import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxWeatherApp extends Application {
    private GridPane root = new GridPane();
    private Scene scene = new Scene(root, 400, 300);

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        buildGUI(stage);
    }

    private void buildGUI(Stage stage){
        stage.setScene(scene);
        stage.setTitle("Pogodynka");
        stage.setResizable(false);
        stage.show();
    }
}
