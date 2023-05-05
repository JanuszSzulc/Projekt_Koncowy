package pl.coderslab.Projekt_Koncowy.offense;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class OffenseManagerImpl implements OffenseManager {
    @Override
    public List<OffenseDto> getAll() {
        return null;
    }

    @Override
    public Optional<OffenseDto> getById(Long id) {
        return Optional.empty();
    }
}
