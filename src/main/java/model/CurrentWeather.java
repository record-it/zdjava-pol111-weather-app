package model;

import lombok.Data;

@Data
public class CurrentWeather {
    private Coordinate coord;
    private Clouds clouds;
    private Main main;
    private Sys sys;
    private Wind wind;
    private Weather weather;
    private String base;
    private int visibility;
    private long dt;
    private int timezone;
    private long id;
    private String name;
    private int cod;
}
