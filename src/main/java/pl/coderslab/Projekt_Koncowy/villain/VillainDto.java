package pl.coderslab.Projekt_Koncowy.villain;

import java.time.LocalDateTime;

public record VillainDto(Long id, String firstName, String lastName, String prison, Double deposit,
                         LocalDateTime createdOn) {

}
