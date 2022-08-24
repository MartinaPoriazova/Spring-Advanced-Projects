package bg.softuni.hateoas.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentEntity  extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<OrderEntity> orders;

    public String getName() {
        return name;
    }

    public StudentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public StudentEntity setDeleted(boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public StudentEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}
