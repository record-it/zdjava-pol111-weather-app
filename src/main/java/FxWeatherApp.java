import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.extern.java.Log;
import repository.OpenWeatherRepository;
import repository.WeatherRepository;

@Log
public class FxWeatherApp extends Application {
    private GridPane root = new GridPane();
    private Scene scene = new Scene(root, 400, 300);
    private static String apiKey;
    WeatherRepository weatherRepository = new OpenWeatherRepository(apiKey);

    public static void main(String[] args) {
        if (args[0] == null){
            System.out.println("Brak klucza!");
            return;
        }
        apiKey = args[0];
        log.info("Klucz: " + apiKey);
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
