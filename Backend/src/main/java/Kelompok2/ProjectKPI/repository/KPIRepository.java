package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KPIRepository extends JpaRepository<KPI,Long> {

}
