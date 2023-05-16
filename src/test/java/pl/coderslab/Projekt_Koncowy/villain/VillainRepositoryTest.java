package pl.coderslab.Projekt_Koncowy.villain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import pl.coderslab.Projekt_Koncowy.offense.OffenseRepository;
import pl.coderslab.Projekt_Koncowy.prison.PrisonRepository;

import java.util.List;

@DataJpaTest
class VillainRepositoryTest {

//    @Autowired
//    TestEntityManager entityManager;
//    @Autowired
//    PrisonRepository prisonRepository;
//    @Autowired
//    OffenseRepository offenseRepository;
//    @Autowired
//    VillainRepository villainRepository;
//
//    @Test
//    public void whenSearchForVillain_thenFindOnlyFromGivenPrison() {
//        Villain villain = entityManager.find(Villain.class,1L);
//
//        List<Villain> villainList = this.villainRepository.findAll(villain);
//
//        Assertions.assertThat(villainList).hasSize(2);
//        Assertions.assertThat(villainList.get(0)).isNotNull();
//        Assertions.assertThat(villainList.get(0)).hasFieldOrPropertyWithValue("id", 2L);
//    }

}