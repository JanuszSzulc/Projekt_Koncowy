package pl.coderslab.Projekt_Koncowy.offense;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.prison.PrisonDto;
import pl.coderslab.Projekt_Koncowy.prison.PrisonRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OffenseManagerImpl implements OffenseManager {

    private final OffenseRepository offenseRepository;

    @Override
    public List<OffenseDto> getAll() {
        List<Offense> offense = offenseRepository.findAll();
        return offense.stream()
                .map(this::toSummary)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OffenseDto> getById(Long id) {
        Optional<Offense> offense = offenseRepository.findById(id);
        return Optional.ofNullable(offense.map(this::toSummary)
                .orElseThrow(() -> new IllegalArgumentException("No offense with id: " + id)));
    }

    private OffenseDto toSummary(Offense offense) {
        return new OffenseDto(offense.getId(),
                offense.getLevel(),
                offense.getDescription());
    }
}
