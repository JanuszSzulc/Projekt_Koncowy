package pl.coderslab.Projekt_Koncowy.offense;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.Projekt_Koncowy.villain.Villain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offenses")
@Getter
@Setter
@ToString
public class Offense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OffenseLevel level;
    private String description;

    @ManyToOne
    private Villain villain;
}
