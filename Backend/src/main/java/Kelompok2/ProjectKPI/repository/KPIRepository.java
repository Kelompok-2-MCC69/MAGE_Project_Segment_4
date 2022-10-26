package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface KPIRepository extends JpaRepository<KPI,Long> {

//    @Transactional
//    @Modifying
//    @Query("UPDATE KPI k join k.assessments a " +
//            "SET kpi.final_score = count(a.m_rating) WHERE k.id = ?1")
//    int countFinalScore(Long id);
}
