package model;
import lombok.Data;
@Data
public class Sys {
    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;
}
