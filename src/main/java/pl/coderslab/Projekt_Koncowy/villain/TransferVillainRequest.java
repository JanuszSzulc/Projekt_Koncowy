package pl.coderslab.Projekt_Koncowy.villain;

import pl.coderslab.Projekt_Koncowy.prison.Prison;

import javax.validation.constraints.NotBlank;

public record TransferVillainRequest(
        Long id,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        Prison prison
) {
}
