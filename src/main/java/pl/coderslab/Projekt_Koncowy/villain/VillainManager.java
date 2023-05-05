package pl.coderslab.Projekt_Koncowy.villain;

import java.util.List;
import java.util.Optional;

public interface VillainManager {
    List<VillainDto> getAll();

    Optional<VillainDto> getById(Long id);

    VillainDto update(UpdateVillainParams updateVillainParams);

    VillainDto create(CreateVillainRequest request);
}
