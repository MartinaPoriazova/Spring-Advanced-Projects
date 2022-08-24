package bg.softuni.hateoas.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class CourseEntity  extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public String getName() {
        return name;
    }

    public CourseEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CourseEntity setPrice(int price) {
        this.price = price;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public CourseEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}
