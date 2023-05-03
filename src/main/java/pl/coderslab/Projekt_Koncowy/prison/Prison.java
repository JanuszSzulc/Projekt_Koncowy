package pl.coderslab.Projekt_Koncowy.prison;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pl.coderslab.Projekt_Koncowy.transfer.Transfer;
import pl.coderslab.Projekt_Koncowy.villain.Villain;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jails")
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
    private String dateOpened;
    @Column(name = "number_of_cells")
    private Integer numberOfCells;

    @OneToMany(mappedBy = "prison")
    @ToString.Exclude
    private List<Villain> villainList = new ArrayList<>();

    @ManyToOne
    private Transfer transfer;
}
