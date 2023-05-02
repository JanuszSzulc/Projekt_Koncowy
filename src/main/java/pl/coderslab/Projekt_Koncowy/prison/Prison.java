package pl.coderslab.Projekt_Koncowy.prison;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "jails")
@Getter
@Setter
@ToString
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

}
