package model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Coordinate {
    private double lon;
    private double lat;
}
