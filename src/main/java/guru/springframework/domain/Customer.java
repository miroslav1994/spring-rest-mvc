package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "customerUrl")
    private String customerUrl;
}
