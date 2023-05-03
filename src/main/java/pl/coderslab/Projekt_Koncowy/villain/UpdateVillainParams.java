package pl.coderslab.Projekt_Koncowy.villain;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record UpdateVillainParams(
        @NotNull
        Long id,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        String originCountry,
        String prison,
        @NotBlank
        String dateOfConviction,
        Double deposit,
        boolean alive) {
}
