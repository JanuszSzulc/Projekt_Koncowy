package pl.coderslab.Projekt_Koncowy.villain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prison/villains")
@Slf4j
@RequiredArgsConstructor

public class VillainController {

    private final VillainManager villainManager;

    @GetMapping
    public List<VillainDto> getAllVillains() {
        List<VillainDto> villains = villainManager.getAll();
        log.debug("Collected {} villains", villains.size());
        return villains;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VillainDto> getVillain(@PathVariable Long id) {
        Optional<VillainDto> villainDto = villainManager.getById(id);
        return villainDto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VillainDto> updateVillain(@PathVariable Long id,
                                                    @RequestBody @Valid UpdateVillainParams request) {
        if (!id.equals(request.id())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not found");
        }
        VillainDto villainDto = villainManager.update(request);
        return ResponseEntity.ok(villainDto);
    }
}
