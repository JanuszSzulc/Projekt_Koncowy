package pl.coderslab.Projekt_Koncowy.villain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.Projekt_Koncowy.offense.Offense;
import pl.coderslab.Projekt_Koncowy.prison.Prison;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "villains")
@Getter
@Setter
@ToString
public class Villain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Column(name = "origin_country")
    private String originCountry;
    @Column(nullable = false, scale = 2)
    private Double prize;
    private Double punishment;
    private boolean alive;

    @OneToMany(mappedBy = "villain")
    @ToString.Exclude
    private List<Offense> offenseList = new ArrayList<>();

    @ManyToOne(optional = false)
    private Prison prison;
}
