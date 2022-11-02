package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KPIRepository extends JpaRepository<KPI,Long> {

//    @Transactional
//    @Modifying
//    @Query("UPDATE KPI k join k.assessments a " +
//            "SET kpi.final_score = count(a.m_rating) WHERE k.id = ?1")
//    int countFinalScore(Long id);

//    @Query(value = "select * from tb_kpi k where k.employee_id = :id",
//            nativeQuery = true)
    @Query(value = "select * from tb_kpi k join tb_employee e on k.employee_id = e.id where k.employee_id = :id",nativeQuery = true)
    List<KPI> getByMyKpi(Long id);
}
