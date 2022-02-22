package repository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import model.CurrentWeather;
import util.OpenWeatherURI;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;

@Log
public class OpenWeatherRepository implements WeatherRepository{
    private ApiRepository<CurrentWeather> weatherApiRepository = new ApiRepository<>(CurrentWeather.class);
    private OpenWeatherURI uri;

    public OpenWeatherRepository(String apiKey) {
        uri = new OpenWeatherURI(apiKey);
    }

    @Override
    public Optional<CurrentWeather> findCurrentWeather(String cityName) {
        log.info("Pobieranie z URI: " + uri.getURIByCity(cityName));
        try {
            return weatherApiRepository.getObject(uri.getURIByCity(cityName));
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage());
            return Optional.empty();
        } catch (InterruptedException e) {
            log.log(Level.WARNING, e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<CurrentWeather> findCurrentWeather(String cityName, String countryCode) {
        log.info("Pobieranie z URI: " + uri.getURIByCityAndCountryCode(cityName, countryCode));
        try {
            return weatherApiRepository.getObject(uri.getURIByCityAndCountryCode(cityName, countryCode));
        } catch (IOException e) {
            log.log(Level.WARNING, e.getMessage());
            return Optional.empty();
        } catch (InterruptedException e) {
            log.log(Level.WARNING, e.getMessage());
            return Optional.empty();
        }
    }
}
