package pl.coderslab.Projekt_Koncowy.villain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .map(this::toSummary)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<VillainDto> getById(Long id) {
        Optional<Villain> villain = villainRepository.findById(id);
        return villain.map(this::toSummary);

    }

    @Override
    public VillainDto update(UpdateVillainParams request) {
        return villainRepository
                .findById(request.id())
                .map(villain -> {
                    villain.setFirstName(request.firstName());
                    if (request.firstName() != null) {
                        villain.setFirstName(request.firstName());
                    }
                    villain.setLastName(request.lastName());
                    if (request.lastName() != null) {
                        villain.setLastName(request.lastName());
                    }
                    villain.setDateOfConviction(request.dateOfConviction());
                    if (request.dateOfConviction() != null) {
                        villain.setDateOfConviction(request.dateOfConviction());
                    }
                    villain.setDeposit(request.deposit());
                    if (request.deposit() != null) {
                        villain.setDeposit(request.deposit());
                    }
//                    villain.setPrison(request.prison());
//                    if (request.prison() != null) {
//                        villain.setPrison(request.prison());
//                    }
                    villain.setAlive(request.alive());
                    return villain;
                })
                .map(villainRepository::save)
                .map(this::toSummary)
                .orElseThrow(() -> new IllegalArgumentException("No villain with id " + request.id()));
    }

    private VillainDto toSummary(Villain villain) {
        return new VillainDto(villain.getId(),
                villain.getFirstName(),
                villain.getLastName(),
                villain.getPrison().getName(),
                villain.getDeposit(),
                villain.getDateOfConviction(),
                villain.isAlive(),
                villain.getCreatedOn());
    }
}
