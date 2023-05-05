package pl.coderslab.Projekt_Koncowy.offense;

import lombok.*;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.villain.Villain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offenses")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Offense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private OffenseLevel level;
    private String description;

    @OneToMany(mappedBy = "offense")
    @ToString.Exclude
    private List<Villain> villainOffenseList = new ArrayList<>();

//    @ManyToOne
//    @JoinColumn(name = "villain_id", nullable = false)
//    private Villain villain;


//    @OneToMany(mappedBy = "offense")
//    private List<Villain> villainList = new ArrayList<>();

//    @ManyToMany
//    @JoinTable(name = "villains_offenses",
//            joinColumns = @JoinColumn(name = "villain_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "offense_id", referencedColumnName = "id"))
//    private List<Villain> villains;
}
