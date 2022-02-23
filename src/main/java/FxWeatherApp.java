import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lombok.Builder;
import lombok.extern.java.Log;
import model.CityWeather;
import model.CurrentWeather;
import repository.JpaOpenWeatherRepository;
import repository.OpenWeatherRepository;
import repository.WeatherRepository;
import service.WeatherService;

import java.time.LocalDate;
import java.util.Optional;

@Log
public class FxWeatherApp extends Application {
    private GridPane root = new GridPane();
    private Scene scene = new Scene(root, 400, 300);
    private Label temperatureLabel = new Label("Temperatura");
    private Label pressureLabel = new Label("Ciśnienie");
    private Button getWeatherInfonButton = new Button("Odśwież");
    private TextField cityField = new TextField();
    private TextField codeField = new TextField();
    private Optional<CityWeather> weather = Optional.empty();
    private static String apiKey;
    WeatherRepository weatherRepository = new OpenWeatherRepository(apiKey);
    JpaOpenWeatherRepository jpaOpenWeatherRepository = new JpaOpenWeatherRepository();
    private WeatherService service = new WeatherService(apiKey);

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
        weather =
                service.findByCityAndDate(cityField.getText(), LocalDate.now());
        log.info("Pobrano: " + weather);
        if (weather.isPresent()){
            temperatureLabel.setText(String.format("%3.1f",weather.get().getMain().getTemp()));
            pressureLabel.setText(String.format("%4d",weather.get().getMain().getPressure()));
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
        root.add(pressureLabel, 2, 2);
        root.add(new Label("Miasto"), 1, 3);
        root.add(cityField, 2, 3);
        root.add(new Label("Kod kraju"), 1, 4);
        root.add(codeField, 2, 4);
        root.add(getWeatherInfonButton, 2, 5);
        stage.setScene(scene);
        stage.setTitle("Pogodynka");
        stage.setResizable(false);
        stage.show();
    }
}
