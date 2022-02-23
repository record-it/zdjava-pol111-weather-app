package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Clouds {
    @Column(name = "_all")
    private int all;
}
