import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Builder;
import lombok.extern.java.Log;
import model.CurrentWeather;
import repository.OpenWeatherRepository;
import repository.WeatherRepository;

import java.util.Optional;

@Log
public class FxWeatherApp extends Application {
    private GridPane root = new GridPane();
    private Scene scene = new Scene(root, 400, 300);
    private Label temperatureLabel = new Label("Temperatura");
    private Button getWeatherInfonButton = new Button("Odśwież");
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

    private void updateWeather(){
        final Optional<CurrentWeather> weather = weatherRepository.findCurrentWeather("Kielce");
        log.info("Pobrano: " + weather);
        if (weather.isPresent()){
            temperatureLabel.setText(String.format("%3.1f",weather.get().getMain().getTemp()));
        }
    }

    private void buildGUI(Stage stage){
        getWeatherInfonButton.setOnAction(actionEvent -> {
            updateWeather();
        });
        root.setPadding(new Insets(10));
        root.add(new Label("Temperatura powietrza:"), 1, 1);
        root.add(temperatureLabel, 2, 1);
        root.add(new Label("Ciśnienie: "), 1, 2);

        root.add(getWeatherInfonButton, 1, 3);
        stage.setScene(scene);
        stage.setTitle("Pogodynka");
        stage.setResizable(false);
        stage.show();
    }
}
