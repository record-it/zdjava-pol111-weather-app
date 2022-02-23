package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CurrentWeather {
    @Embedded
    private Coordinate coord;
    @Embedded
    private Clouds clouds;
    @Embedded
    private Main main;
    @Embedded
    private Sys sys;
    @Embedded
    private Wind wind;
    transient
    private List<Weather> weather;
    private String base;
    private int visibility;
    private long dt;
    private int timezone;
    @Id
    @EqualsAndHashCode.Include
    private long id;
    private String name;
    private int cod;
}
