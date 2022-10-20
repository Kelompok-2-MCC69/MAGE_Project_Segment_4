package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History,Long> {
    Optional<History> findByName(String name);

}
