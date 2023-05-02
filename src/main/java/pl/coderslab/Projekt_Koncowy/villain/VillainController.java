package pl.coderslab.Projekt_Koncowy.villain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
