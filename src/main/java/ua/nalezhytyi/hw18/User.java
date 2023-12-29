package ua.nalezhytyi.hw18;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString(exclude = "orderList")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 50)
    private String userName;

    @Column(name = "user_email", length = 50)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
