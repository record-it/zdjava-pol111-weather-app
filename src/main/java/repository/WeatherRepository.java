package repository;

import model.CurrentWeather;

import java.util.Optional;

public interface WeatherRepository {
    Optional<CurrentWeather> findCurrentWeather(String cityName);
}
