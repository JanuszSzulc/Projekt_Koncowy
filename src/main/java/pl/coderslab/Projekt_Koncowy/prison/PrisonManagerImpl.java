package pl.coderslab.Projekt_Koncowy.prison;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.Projekt_Koncowy.villain.Villain;
import pl.coderslab.Projekt_Koncowy.villain.VillainDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrisonManagerImpl implements PrisonManager {

    private final PrisonRepository prisonRepository;

    @Override
    public List<PrisonDto> getAll() {
        List<Prison> prisonsers = prisonRepository.findAll();
        return prisonsers.stream()
                .map(this::toSummary)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PrisonDto> getById(Long id) {
        Optional<Prison> prison = prisonRepository.findById(id);
        return Optional.ofNullable(prison.map(this::toSummary)
                .orElseThrow(() -> new IllegalArgumentException("No prison with id: " + id)));
    }

    private PrisonDto toSummary(Prison prison) {
        return new PrisonDto(prison.getId(),
                prison.getName(),
                prison.getDateOpened(),
                prison.getNumberOfCells());
    }
}
