package pl.coderslab.Projekt_Koncowy.villain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class VillainManagerImpl implements VillainManager {
    @Override
    public List<VillainDto> getAll() {
        return List.of();
    }
}
