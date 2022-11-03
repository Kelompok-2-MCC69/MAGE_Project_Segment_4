package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AssessmentsRepository extends JpaRepository<Assessment,Long> {
    @Query(value = "select a.id,a.indicator,a.weight,a.kpi_rating,a.e_comment,a.e_rating,a.m_comment," +
            "a.m_rating,a.score,a.kpi_id from tb_assessment a join tb_kpi k " +
            "on k.id = a.kpi_id where a.kpi_id = :id", nativeQuery = true)
    List<Assessment> getByKPI(Long id);

    @Query(value = "select sum(a.m_rating * (a.weight / 100)) as total  from tb_assessment a where a.kpi_id = :id", nativeQuery = true)
    Integer sumScore(Long id);

    @Query(value = "select sum(a.m_rating * (a.weight / 100)) as total  from tb_assessment a where a.id = :id",nativeQuery = true)
    Integer subTotal(Long id);
}
