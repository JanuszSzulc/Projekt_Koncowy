package pl.coderslab.Projekt_Koncowy.offense;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/offense")
@Slf4j
@RequiredArgsConstructor
public class OffenseController {
    private final OffenseManager offenseManager;

    @GetMapping
    public List<OffenseDto> getAllOffenses() {
        List<OffenseDto> offense = offenseManager.getAll();
        log.debug("Collected {} offenses", offense.size());
        return offense;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OffenseDto> getOffense(@PathVariable Long id) {
        Optional<OffenseDto> offenseDto = offenseManager.getById(id);
        return offenseDto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
