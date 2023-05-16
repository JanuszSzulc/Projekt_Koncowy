package pl.coderslab.Projekt_Koncowy.villain;

import javax.validation.constraints.NotBlank;
import java.util.List;

public record TransferPrisonRequest(
        @NotBlank
        Long id,
        @NotBlank
        String name,
        boolean executionStatus,
        List<Villain> villainList) {
}
