package pl.coderslab.Projekt_Koncowy.villain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class VillainManagerImpl implements VillainManager {

    private final VillainRepository villainRepository;

    @Override
    public List<VillainDto> getAll() {
        List<Villain> villains = villainRepository.findAll();
        return villains.stream()
                .map(villain -> toSummary(villain))
                .collect(Collectors.toList());
    }

    private VillainDto toSummary(Villain villain) {
        return new VillainDto(villain.getId(), villain.getFirstName(), villain.getLastName(), villain.getPrison().getName(),
                villain.getDeposit(), villain.getCreatedOn());
    }
}
