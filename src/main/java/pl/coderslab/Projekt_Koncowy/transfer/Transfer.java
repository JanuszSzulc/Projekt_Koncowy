package pl.coderslab.Projekt_Koncowy.transfer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "transfers")
@Getter
@Setter
@ToString
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
}
