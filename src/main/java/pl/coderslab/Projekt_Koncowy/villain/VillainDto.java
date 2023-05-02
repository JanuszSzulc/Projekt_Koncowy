package pl.coderslab.Projekt_Koncowy.villain;

import java.time.LocalDateTime;

public record VillainDto(String firstName, String lastName, Double deposit, Double punishment, LocalDateTime date) {
}
