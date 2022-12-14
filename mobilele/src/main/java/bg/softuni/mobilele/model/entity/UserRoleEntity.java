package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    public UserRoleEntity() {
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum name) {
        this.userRole = name;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "userRole=" + userRole +
                '}';
    }
}
