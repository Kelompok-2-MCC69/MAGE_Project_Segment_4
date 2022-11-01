package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job,Long> {
    Optional<Job> findByCode(String code);
    Optional<Job> findByTitle(String title);
}
