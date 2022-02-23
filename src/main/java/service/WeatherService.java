package service;

import model.CityWeather;
import model.CurrentWeather;
import repository.JpaOpenWeatherRepository;
import repository.OpenWeatherRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class WeatherService {
    private final OpenWeatherRepository openWeatherRepository;
    private final JpaOpenWeatherRepository jpaOpenWeatherRepository = new JpaOpenWeatherRepository();

    public WeatherService(String keyApi) {
        this.openWeatherRepository = new OpenWeatherRepository(keyApi);
    }

    public Optional<CityWeather> findByCityAndDate(String city, LocalDate date){
        List<CityWeather> cityWeather = jpaOpenWeatherRepository.findCityWeather(city, date);
        if (cityWeather.isEmpty()){
            final Optional<CurrentWeather> currentWeather = openWeatherRepository.findCurrentWeather(city);
            return currentWeather.map(weather -> jpaOpenWeatherRepository.saveCityWeather(weather, city));
        }
        return cityWeather.stream().findFirst();
    }
}
