package repository;

import model.CurrentWeather;
import util.OpenWeatherURI;

import java.io.IOException;
import java.util.Optional;

public class OpenWeatherRepository implements WeatherRepository{
    private ApiRepository<CurrentWeather> weatherApiRepository = new ApiRepository<>(CurrentWeather.class);
    private OpenWeatherURI uri = new OpenWeatherURI("asdasd");
    @Override
    public Optional<CurrentWeather> findCurrentWeather(String cityName) {
        try {
            return weatherApiRepository.getObject(uri.getURIByCity(cityName));
        } catch (IOException e) {
            return Optional.empty();
        } catch (InterruptedException e) {
            return Optional.empty();
        }
    }
}
