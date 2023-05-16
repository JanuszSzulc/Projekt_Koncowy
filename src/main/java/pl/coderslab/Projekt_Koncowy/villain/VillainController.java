package pl.coderslab.Projekt_Koncowy.villain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.prison.PrisonManager;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/villains")
@Slf4j
@RequiredArgsConstructor

public class VillainController {
    private final VillainManager villainManager;
    private final PrisonManager prisonManager;

    @GetMapping
    public List<Villain> getAllVillains() {
        List<Villain> villain = villainManager.getAll();
        log.debug("Collected {} prisoners", villain.size());
        return villain.stream().toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VillainDto> getVillain(@PathVariable Long id) {
        Optional<VillainDto> villainDto = villainManager.getById(id);
        return villainDto
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //, produces = MediaType.APPLICATION_JSON_VALUE
    @GetMapping("/allVillainsByPrisonId/{id}")
    public List<Villain> findVillainsByPrison(@PathVariable Long id) {
        Prison prison = prisonManager.getById(id)
                .orElseThrow(() -> new RuntimeException("No prison with id: " + id));

        List<Villain> villainList = villainManager.getAll();

        return villainManager.findAllVillainsContains(villainList);


//.orElseThrow(() -> new RuntimeException("No prison with id: " + id)
//        Collection<Villain> villains = new ArrayList<>();

//        return villainManager.findAllVillainsContains(getAllVillains()
//                .stream()
//                .collect(Collectors.toCollection(this::getAllVillains)));

//        List<VillainDto> villainList = villainManager.getAll();
//
//        return villainManager.findAllVillainsContains(villainList).toString();
    }
//        List<Villain> villainList = villainManager.getAll();
//
//        return villainManager.findAllVillainsContains(villainList);


//            return prison.stream().collect(Collectors.toCollection(this::getAllVillains));
//            List<Villain> villainList = villainManager.getAll();


//        @GetMapping("/allVillainsByPrisonId/{id}")
//        public List<Villain> findVillainsByPrison(@PathVariable Long id) {
//            Prison prison = prisonManager.getById(id)
//                    .orElseThrow(() -> new RuntimeException("No prison with id: " + id));
//
//            List<Villain> villain = villainManager.getAll();
//
//            return villainManager.findAllVillainsContains(villain);


    @PutMapping("/{id}")
    public ResponseEntity<VillainDto> updateVillain(@PathVariable Long id,
                                                    @RequestBody @Valid UpdateVillainParams request) {
        if (!id.equals(request.id())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not found");
        }
        VillainDto villainDto = villainManager.update(request);
        return ResponseEntity.ok(villainDto);
    }

    @PostMapping
    public ResponseEntity<?> createVillain(@RequestBody @Valid CreateVillainRequest request) {
        VillainDto summary = villainManager.create(request);
        return ResponseEntity.created(URI.create("/prison/villains" + summary.id())).body(summary);
    }

//    @PutMapping("/transfer/{id}/{id}")
//    public ResponseEntity<?> transferVillainToPrison(@PathVariable Long prisonId, Long villainId,
//                                                     @RequestBody @Valid TransferVillainRequest requestVillain,
//                                                     @RequestBody @Valid TransferPrisonRequest requestPrison) {
//        if (!prisonId.equals(requestPrison.id())) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Prison ID not found");
//            if (!villainId.equals(requestVillain.id())) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Villain ID not found");
//            }
//        }
//        TransferDto prisonDto = prisonManager.transfer(requestPrison);
//        return ResponseEntity.ok(prisonDto);
//
//        VillainDto villainDto = villainManager.transfer(requestVillain);
//        return ResponseEntity.ok(villainDto);
//    }
}