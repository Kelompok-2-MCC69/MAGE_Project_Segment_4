package Kelompok2.ProjectKPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate created_at = LocalDate.now();

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate first_deadline = created_at.plusYears(1);

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate second_deadline = first_deadline.plusMonths(1);

    private Long final_score;

    private Integer year = created_at.getYear();

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
