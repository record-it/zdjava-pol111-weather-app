package model;

import lombok.Data;

import java.util.List;

@Data
public class CurrentWeather {
    private Coordinate coord;
    private Clouds clouds;
    private Main main;
    private Sys sys;
    private Wind wind;
    private List<Weather> weather;
    private String base;
    private int visibility;
    private long dt;
    private int timezone;
    private long id;
    private String name;
    private int cod;
}
