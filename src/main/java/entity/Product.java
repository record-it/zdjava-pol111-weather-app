package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    private long id;

    private BigDecimal price;

    private BigDecimal vat;
}
