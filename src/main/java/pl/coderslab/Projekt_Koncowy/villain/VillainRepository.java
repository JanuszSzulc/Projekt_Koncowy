package pl.coderslab.Projekt_Koncowy.villain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VillainRepository extends JpaRepository<Villain, Long> {

    Optional<Villain> findById(Long id);

    @Query(value = "select b.villainList, v.prison, v.offense from Prison b, Villain v where  b.villainList = ?1")
    List<Villain> findVillainsList(List<VillainDto> villainList);


//    @Query(value = "select b.villainList from Prison b where b.id = ?1")

//    List<Villain> findVillains(Prison villainList);


//    @Query(value = "select b.villainList from Prison b where b. = ?1")
//    ResponseEntity<List<Villain>> findVillainsList(List<Villain> villainList);


//    @Query(value = "select b from Prison b where b.villainList = ?1")
//    Optional<VillainDto> findAll(Optional<PrisonDto> prison);

}
