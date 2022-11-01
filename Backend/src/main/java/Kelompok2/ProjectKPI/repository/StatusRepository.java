package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.Job;
import Kelompok2.ProjectKPI.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status,Long> {
    Optional<Job> findByName(String name);
}
