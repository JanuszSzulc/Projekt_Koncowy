package pl.coderslab.Projekt_Koncowy.villain;

import pl.coderslab.Projekt_Koncowy.prison.Prison;

import javax.validation.constraints.NotBlank;

public record UpdateVillainParams(
        Long id,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        Prison prison,
        String originCountry,
        Double deposit,
        @NotBlank
        String dateOfConviction,
        boolean alive,
        Long offense) {
}
