package bg.softuni.errors.model;

import java.math.BigDecimal;

public class ProductDTO {

    private final String name;
    private final BigDecimal price;


    public ProductDTO(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
