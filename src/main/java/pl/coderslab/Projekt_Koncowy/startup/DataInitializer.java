package pl.coderslab.Projekt_Koncowy.startup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.Projekt_Koncowy.offense.Offense;
import pl.coderslab.Projekt_Koncowy.offense.OffenseLevel;
import pl.coderslab.Projekt_Koncowy.offense.OffenseRepository;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.prison.PrisonRepository;
import pl.coderslab.Projekt_Koncowy.villain.Villain;
import pl.coderslab.Projekt_Koncowy.villain.VillainRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Profile("local")
@Component
@Slf4j
@RequiredArgsConstructor
public class DataInitializer {

    private final PrisonRepository prisonRepository;
    private final VillainRepository villainRepository;
    private final OffenseRepository offenseRepository;

//    private final TransferRepository transferRepository;

    @EventListener
    @Transactional
    public void loadInitialData(ContextRefreshedEvent unused) {

        log.info("Loading initial data...");

        Prison atlanta =
                Prison.builder()
                        .name("Atlanta")
                        .dateOpened("01.01.1902")
                        .numberOfCells(793)
                        .build();
        prisonRepository.save(atlanta);

        Prison leavenworth =
                Prison.builder()
                        .name("Fort Leavenworth")
                        .dateOpened("01.01.1902")
                        .numberOfCells(1000)
                        .build();
        prisonRepository.save(leavenworth);

        Prison alcatraz =
                Prison.builder()
                        .name("Alcatraz")
                        .dateOpened("11.08.1934")
                        .numberOfCells(378)
                        .build();
        prisonRepository.save(alcatraz);

        Offense taxFrauds =
                Offense.builder()
                        .level(OffenseLevel.MEDIUM)
                        .description("tax frauds")
                        .build();
        offenseRepository.save(taxFrauds);

        Offense murder =
                Offense.builder()
                        .level(OffenseLevel.VERY_HIGH)
                        .description("murder of people")
                        .build();
        offenseRepository.save(murder);

        Villain alCapone =
                Villain.builder()
                        .prison(atlanta)
                        .firstName("Alphonse")
                        .lastName("Capone")
                        .originCountry("USA")
                        .dateOfConviction("16.11.1939")
                        .deposit(1000000.05)
                        .offense(taxFrauds)
                        .alive(true)
                        .build();
        villainRepository.save(alCapone);

        Villain robertShroud =
                Villain.builder()
                        .prison(leavenworth)
                        .firstName("Robert")
                        .lastName("Stroud")
                        .originCountry("USA")
                        .dateOfConviction("23.02.1909")
                        .deposit(500000.01)
                        .offense(murder)
                        .alive(true)
                        .build();
        villainRepository.save(robertShroud);

        alcatraz.setVillainList(new ArrayList<>(Collections.singleton(alCapone)));
        leavenworth.setVillainList(new ArrayList<>(Collections.singleton(robertShroud)));

        taxFrauds.setVillainOffenseList(List.of(alCapone));
        murder.setVillainOffenseList(List.of(robertShroud));

//        Transfer transferAlcatraz =
//                Transfer.builder()
//                        .destinationPrison("Alcatraz")
//                        .reason("stricter rigor")
//                        .executionStatus(false)
//                        .transferDate(null)
//                        .build();
//        transferRepository.save(transferAlcatraz);

        log.info("Initial data loaded.");
    }
}