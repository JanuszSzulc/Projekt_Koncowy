package pl.coderslab.Projekt_Koncowy.villain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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
        @NotNull
        Long offense,
        String description
) {
}
