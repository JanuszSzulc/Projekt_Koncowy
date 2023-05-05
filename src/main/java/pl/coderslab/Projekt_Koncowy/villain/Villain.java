package pl.coderslab.Projekt_Koncowy.villain;

import lombok.*;
import pl.coderslab.Projekt_Koncowy.offense.Offense;
import pl.coderslab.Projekt_Koncowy.offense.OffenseLevel;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.transfer.Transfer;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "villains")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Villain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "origin_country")
    private String originCountry;
    @Column(name = "date_of_conviction")
    @Pattern(regexp = "^\\d{2}\\.\\d{2}\\.\\d{4}$", message = "Date Of Conviction must be in format dd.MM.yyyy")
    private String dateOfConviction;
    @Column(nullable = false, scale = 2)
    private Double deposit;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(nullable = false)
    private boolean alive;

//    @OneToMany(mappedBy = "villain")
//    private List<Offense> offenseList = new ArrayList<>();

    @ManyToOne(optional = false)
    private Prison prison;

    @ManyToOne(optional = false)
    private Offense offense;

    @ManyToOne
    private Transfer transfer;


//    @ManyToMany(mappedBy = "villains")
//    private List<Offense> offenseList;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
    }

}
