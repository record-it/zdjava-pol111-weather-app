package util;

import java.net.URI;

public class OpenWeatherURI {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String apiKey;

    public OpenWeatherURI(String apiKey) {
        this.apiKey = apiKey;
    }

    public URI getURIByCity(String cityName){
        return URI.create(String.format("%s?q=%s&appid=%s",BASE_URL, cityName, apiKey));
    }
}
