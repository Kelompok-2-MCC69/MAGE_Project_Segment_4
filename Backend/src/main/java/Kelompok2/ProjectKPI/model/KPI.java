package Kelompok2.ProjectKPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate created_at;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate first_deadline;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(nullable = false)
    private LocalDate second_deadline;

    private Long final_score;

    private Integer year;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    @JoinColumn()
    private Employee manager;

    @ManyToOne
    private Status current_stats;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "kpi",cascade = CascadeType.ALL)
    private List<Assessment> assessments;

    @OneToMany(mappedBy = "kpi")
    private List<History> histories;
}
