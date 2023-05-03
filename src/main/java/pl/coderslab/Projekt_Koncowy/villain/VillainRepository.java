package pl.coderslab.Projekt_Koncowy.villain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VillainRepository extends JpaRepository<Villain, Long> {

    Optional<Villain> findById(Long id);

}
