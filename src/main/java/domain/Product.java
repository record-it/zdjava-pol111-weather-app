package domain;

import java.math.BigDecimal;

public class Product {

    private final long id;

    private final BigDecimal price;

    private final BigDecimal vat;

    private Product(long id, BigDecimal price, BigDecimal vat) {
        this.id = id;
        this.price = price;
        this.vat = vat;
    }

    public static Product Product(BigDecimal price, BigDecimal vat){
        if (price == null || vat == null){
            throw new IllegalArgumentException("Price nie może być null");
        }
        return new Product(1L, price, vat);
    }

    public BigDecimal getBrutto(){
        return price.multiply(vat);
    }

    public long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getVat() {
        return vat;
    }
}
