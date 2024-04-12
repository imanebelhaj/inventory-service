package dao.repositories;

import dao.entities.Creator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreatorRepository extends JpaRepository<Creator, Integer> {
    Optional<Creator> findByName(String name);
}
