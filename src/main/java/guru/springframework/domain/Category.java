package guru.springframework.domain;

import lombok.CustomLog;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}
