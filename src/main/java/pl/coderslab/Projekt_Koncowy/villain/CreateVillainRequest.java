package pl.coderslab.Projekt_Koncowy.villain;

import pl.coderslab.Projekt_Koncowy.offense.Offense;

import javax.validation.constraints.NotBlank;
import java.util.List;

public record CreateVillainRequest(
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        String originCountry,
        @NotBlank
        String prisonName,
        @NotBlank
        String dateOfConviction,
        Double deposit,
        boolean alive,
        Long offense,
        String description
) {
}
