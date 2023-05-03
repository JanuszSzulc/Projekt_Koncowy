package pl.coderslab.Projekt_Koncowy.villain;

import lombok.*;
import pl.coderslab.Projekt_Koncowy.offense.Offense;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.transfer.Transfer;

import javax.persistence.*;
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
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 30)
    private String lastName;
    @Column(name = "origin_country")
    private String originCountry;
    @Column(name = "date_of_conviction")
    private String dateOfConviction;
    @Column(nullable = false, scale = 2)
    private Double deposit;
    @Column(name = "created_on")
    private LocalDateTime createdOn;
    @Column(nullable = false)
    private boolean alive;

    @OneToMany(mappedBy = "villain")
    @ToString.Exclude
    private List<Offense> offenseList = new ArrayList<>();

    @ManyToOne(optional = false)
    private Prison prison;

    @ManyToOne
    private Transfer transfer;

//    @ManyToMany(mappedBy = "villain")
//    private List<Offense> offense;

    @PrePersist
    public void prePersist() {
        this.createdOn = LocalDateTime.now();
    }
}
