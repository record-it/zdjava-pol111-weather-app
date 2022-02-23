package model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Sys {
    private int type;
    @Column(name = "id_sys")
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;
}
