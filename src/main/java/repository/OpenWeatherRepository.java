package repository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import model.CurrentWeather;
import util.OpenWeatherURI;

import java.io.IOException;
import java.util.Optional;

@Log
public class OpenWeatherRepository implements WeatherRepository{
    private ApiRepository<CurrentWeather> weatherApiRepository = new ApiRepository<>(CurrentWeather.class);
    private OpenWeatherURI uri;

    public OpenWeatherRepository(String apiKey) {
        uri = new OpenWeatherURI(apiKey);
    }

    @Override
    public Optional<CurrentWeather> findCurrentWeather(String cityName) {
        try {
            return weatherApiRepository.getObject(uri.getURIByCity(cityName));
        } catch (IOException e) {
            log.throwing(OpenWeatherRepository.class.getName(), "findCurrentWeather", e);
            return Optional.empty();
        } catch (InterruptedException e) {
            log.throwing(OpenWeatherRepository.class.getName(), "findCurrentWeather", e);
            return Optional.empty();
        }
    }
}
