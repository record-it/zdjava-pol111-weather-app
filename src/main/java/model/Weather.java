package model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
