package pl.coderslab.Projekt_Koncowy.prison;

import java.util.List;
import java.util.Optional;

public interface PrisonManager {
    List<PrisonDto> getAll();

    Optional<PrisonDto> getById(Long id);
}
