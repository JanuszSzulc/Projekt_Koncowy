package pl.coderslab.Projekt_Koncowy.villain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.coderslab.Projekt_Koncowy.offense.Offense;
import pl.coderslab.Projekt_Koncowy.offense.OffenseLevel;
import pl.coderslab.Projekt_Koncowy.offense.OffenseRepository;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.prison.PrisonRepository;
import pl.coderslab.Projekt_Koncowy.transfer.TransferRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class VillainManagerImpl implements VillainManager {

    private final VillainRepository villainRepository;
    private final PrisonRepository prisonRepository;
    private final OffenseRepository offenseRepository;
    private final TransferRepository transferRepository;

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
        return Optional.ofNullable(villain.map(this::toSummary)
                .orElseThrow(() -> new IllegalArgumentException("No villain with id: " + id)));

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

    @Override
    public VillainDto create(CreateVillainRequest request) {
        Prison prison =
                prisonRepository
                        .findByName(request.prisonName())
                        .orElseThrow(
                                () -> new IllegalArgumentException("No prison with name " + request.prisonName()));

        Offense offense =
                offenseRepository
                        .findById(request.offense())
                        .orElseThrow(
                                () -> new IllegalArgumentException("No offense with id " + request.offense()));
        List<Offense> changeList = offenseRepository.findAllById(offense.getId());

        if (changeList.isEmpty()) {
            throw new IllegalStateException("No offenses");
        }

        Villain villain =
                Villain.builder()
                        .firstName(request.firstName())
                        .lastName(request.lastName())
                        .originCountry(request.originCountry())
                        .prison(prison)
                        .dateOfConviction(request.dateOfConviction())
                        .deposit(request.deposit())
                        .alive(request.alive())
                        .offense(offense)
                        .build();
        villainRepository.save(villain);

//        for (Offense offense1 : changeList) {
//            offense1.setVillain(villain);
//        }
//        offenseRepository.saveAll(changeList);
        return toSummary(villain);
    }

    private VillainDto toSummary(Villain villain) {
        return new VillainDto(villain.getId(),
                villain.getFirstName(),
                villain.getLastName(),
                villain.getPrison().getName(),
                villain.getOriginCountry(),
                villain.getDeposit(),
                villain.getDateOfConviction(),
                villain.isAlive(),
                villain.getCreatedOn(),
                villain.getOffense().getId(),
                villain.getOffense().getDescription());
    }
}

