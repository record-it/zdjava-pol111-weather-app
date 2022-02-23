package model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Wind {
    private double speed;
    private int deg;
    private double gust;
}
