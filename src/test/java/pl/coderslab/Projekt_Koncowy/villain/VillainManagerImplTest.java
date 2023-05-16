package pl.coderslab.Projekt_Koncowy.villain;

import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.coderslab.Projekt_Koncowy.offense.Offense;
import pl.coderslab.Projekt_Koncowy.offense.OffenseRepository;
import pl.coderslab.Projekt_Koncowy.prison.Prison;
import pl.coderslab.Projekt_Koncowy.prison.PrisonRepository;
import pl.coderslab.Projekt_Koncowy.transfer.TransferRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VillainManagerImplTest {

    @Mock
    VillainRepository villainRepository;
    @Mock
    PrisonRepository prisonRepository;
    @Mock
    OffenseRepository offenseRepository;
    @Mock
    TransferRepository transferRepository;

    @InjectMocks
    VillainManagerImpl villainManager;

    @Test
    public void whenCreateVillain_withNonExistingPrison_fail() {
        Mockito.when(prisonRepository.findByName("Non_exist"))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () ->
                        villainManager.create(
                                new CreateVillainRequest("name", "lastName", "country",
                                        "Non_exist", "01.01.2022", 100.55, true,
                                        1L, "robbery")));
        assertThat(exception)
                .hasMessageContaining("No prison with name Non_exist");
    }

    @Test
    public void whenCreateVillain_withNonExistingOffense_fail() {
        Prison prison = Prison.builder().name("prison").build();
        Mockito.when(prisonRepository.findByName("prison")).thenReturn(Optional.of(prison));

        RuntimeException exception = assertThrows(RuntimeException.class,
                () ->
                        villainManager.create(
                                new CreateVillainRequest("name", "lastName", "country",
                                        "prison", "01.01.2022", 100.55, true,
                                        101L, "robbery")));
        assertThat(exception)
                .hasMessageContaining("No offense with id 101");
    }

    @Test
    public void whenCreate_success() {
        Prison prison = Prison.builder().name("prison").build();
        Offense offense = Offense.builder().id(101L).build();
        Villain villain = Villain.builder().firstName("name").lastName("lastName")
                .prison(prison)
                .offense(offense)
                .build();

        Mockito.when(prisonRepository.findByName("prison")).thenReturn(Optional.ofNullable(prison));
        Mockito.when(offenseRepository.findById(101L)).thenReturn(Optional.ofNullable(offense));

        villainManager.create(new CreateVillainRequest("name", "lastName", "country",
                "prison", "01.01.2022", 100.55, true,
                101L, "robbery"));

        assertThat(villain)
                .hasFieldOrPropertyWithValue("firstName", "name")
                .hasFieldOrPropertyWithValue("lastName", "lastName");
        assertThat(prison)
                .hasFieldOrPropertyWithValue("name", "prison");
        assertThat(offense)
                .hasFieldOrPropertyWithValue("id", 101L);

    }

    @Test
    public void whenCreateVillainToHavePrison_success() {
        Prison prison = Prison.builder().name("prisonName").build();
        Offense offense = Offense.builder().id(101L).build();

        Mockito.when(prisonRepository.findByName("prisonName")).thenReturn(Optional.of(prison));
        Mockito.when(offenseRepository.findById(101L)).thenReturn(Optional.of(offense));

        villainManager.create(new CreateVillainRequest("name", "lastName", "country",
                "prisonName", "01.01.2022", 100.55, true,
                101L, "robbery"));

        assertThat(prison)
                .hasFieldOrPropertyWithValue("name", "prisonName");
    }

    @Test
    public void whenCreateVillainToHaveOffense_success() {
        Prison prison = Prison.builder().name("prisonName").build();
        Offense offense = Offense.builder().id(101L).build();

        Mockito.when(prisonRepository.findByName("prisonName")).thenReturn(Optional.of(prison));
        Mockito.when(offenseRepository.findById(101L)).thenReturn(Optional.of(offense));

        villainManager.create(new CreateVillainRequest("name", "lastName", "country",
                "prisonName", "01.01.2022", 100.55, true,
                101L, "robbery"));

        assertThat(offense)
                .hasFieldOrPropertyWithValue("id", 101L);
    }

}