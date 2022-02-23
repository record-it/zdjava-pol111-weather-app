package mapper;

import model.CityWeather;
import model.CurrentWeather;

public class WeatherMapper {
    public static CityWeather mapTo(CurrentWeather weather, String city){
        return CityWeather.builder()
                .main(weather.getMain())
                .sys(weather.getSys())
                .weatherId(weather.getId())
                .city(city)
                .build();
    }
}
