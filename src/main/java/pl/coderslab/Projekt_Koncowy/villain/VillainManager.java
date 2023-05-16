package pl.coderslab.Projekt_Koncowy.villain;

import pl.coderslab.Projekt_Koncowy.prison.Prison;

import java.util.List;
import java.util.Optional;

public interface VillainManager {

    List<Villain> getAll();

    Optional<VillainDto> getById(Long id);

    VillainDto update(UpdateVillainParams updateVillainParams);

    VillainDto create(CreateVillainRequest request);

    List<Villain> findAllVillainsContains(List<Villain> villainList);


//    ResponseEntity<List<Villain>> findAllVillainsContains(List<Villain> villain);

}
