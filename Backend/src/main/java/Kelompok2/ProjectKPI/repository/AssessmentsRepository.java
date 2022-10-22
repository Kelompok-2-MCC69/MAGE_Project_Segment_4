package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssessmentsRepository extends JpaRepository<Assessment,Long> {

    Optional<Assessment> findByIndicator(String indicator);
}
