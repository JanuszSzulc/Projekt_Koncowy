package pl.coderslab.Projekt_Koncowy.prison;

import lombok.*;
//import pl.coderslab.Projekt_Koncowy.transfer.Transfer;
import pl.coderslab.Projekt_Koncowy.villain.Villain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "prisons")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Prison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 30)
    private String name;
    @Column(name = "date_opened")
    @Pattern(regexp = "^\\d{2}\\.\\d{2}\\.\\d{4}$", message = "Date opened must be in format dd.MM.yyyy")
    private String dateOpened;
    @Column(name = "number_of_cells")
    private Integer numberOfCells;


    @OneToMany(mappedBy = "prison")
    @ToString.Exclude
    private List<Villain> villainList = new ArrayList<>();

//    public Prison(List<Villain> villains) {
//        this.villainList = villains;
//    }

//    @ManyToOne
//    private Transfer transfer;

}
