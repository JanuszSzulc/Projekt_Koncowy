package pl.coderslab.Projekt_Koncowy.prison;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrisonManagerImpl implements PrisonManager {

    private final PrisonRepository prisonRepository;
//    private final TransferRepository transferRepository;

    @Override
    public List<PrisonDto> getAll() {
        List<Prison> prisons = prisonRepository.findAll();
        return prisons.stream().map(this::toSummary).collect(Collectors.toList());
    }

    @Override
    public Optional<PrisonDto> getById(Long id) {
        Optional<Prison> prison = prisonRepository.findById(id);
        return prison.map(this::toSummary);
    }

    @Override
    public Optional<PrisonDto> findByName(String name) {
        Optional<Prison> prison = prisonRepository.findByName(name);
        return Optional.ofNullable(prison.map(this::toSummary)
                .orElseThrow(() -> new IllegalArgumentException("No prison with name: " + name)));
    }


//    @Override
//    public TransferDto transfer(TransferPrisonRequest requestPrison) {
//        return transferRepository
//                .findById(requestPrison.id())
//                .map(
//                        executionStatus -> {
//                            executionStatus.setId(requestPrison.id());
//                            if (requestPrison.id() != null) {
//                                executionStatus.setExecutionStatus(requestPrison.executionStatus());
//                            }
//                            executionStatus.setExecutionStatus(requestPrison.executionStatus());
//                            if (requestPrison.name() != null) {
//                                executionStatus.setExecutionStatus(requestPrison.executionStatus());
//                            }
//                            executionStatus.setExecutionStatus(true);
//
//                            return executionStatus;
//                        })
//                .map(transferRepository::save)
//                .map(this::toSummary)
//                .orElseThrow(() -> new IllegalArgumentException("No prison with id " + requestPrison.id()));
////                .orElseThrow(() -> new IllegalArgumentException("No prison with name " + requestPrison.name()));
//    }

    private PrisonDto toSummary(Prison prison) {
        return new PrisonDto(prison.getId(),
                prison.getName(),
                prison.getDateOpened(),
                prison.getNumberOfCells());
    }
//    private TransferDto toSummary(Transfer transfer) {
//        return new TransferDto(transfer.getId(),
//                transfer.getDestinationPrison(),
//                transfer.getReason(),
//                transfer.isExecutionStatus(),
//                transfer.getTransferDate(),
//                transfer.getVillain(),
//                transfer.getPrisons());
//    }
}