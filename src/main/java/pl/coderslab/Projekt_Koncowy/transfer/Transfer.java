package pl.coderslab.Projekt_Koncowy.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.villain.Villain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transfers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "destinaton_prison", nullable = false)
    private String destinationPrison;
    private String reason;
    @Column(name = "execution_status")
    private boolean executionStatus;
    @Column(name = "transfer_date")
    private String transferDate;

    @OneToMany(mappedBy = "transfer")
    @ToString.Exclude
    private List<Villain> villain = new ArrayList<>();

    @OneToMany(mappedBy = "transfer")
    @ToString.Exclude
    private List<Prison> prisons = new ArrayList<>();
}
