package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_kpi")
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime created_at;

    private LocalDateTime first_deadline;

    private LocalDateTime second_deadline;

    private Long final_score;

    private Date year;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Employee manager;

    @ManyToOne
    private Status current_stats;

    @OneToMany(mappedBy = "kpi")
    private List<Assessment> assessments;

    @OneToMany(mappedBy = "kpi")
    private List<History> histories;
}
