package pl.coderslab.Projekt_Koncowy.prison;

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
@RequestMapping("/prisons")
@Slf4j
@RequiredArgsConstructor
public class PrisonController {
    private final PrisonManager prisonManager;

    @GetMapping
    public List<PrisonDto> getAll() {
        List<PrisonDto> prison = prisonManager.getAll();
        log.debug("Collected {} prisoners", prison.size());
        return prison;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrisonDto> getPrison(@PathVariable Long id) {
        Optional<PrisonDto> prison = prisonManager.getById(id);
        return prison.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<PrisonDto> getPrisonByName(@PathVariable String name) {
        Optional<PrisonDto> prisonDto = prisonManager.findByName(name);
        return prisonDto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
