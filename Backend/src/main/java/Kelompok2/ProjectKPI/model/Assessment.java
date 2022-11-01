package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_assessment")
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String indicator;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private String kpiRating;

    private String e_comment;

    private Integer e_rating;

    private String  m_comment;

    private Integer m_rating;

    @ManyToOne
    private KPI kpi;

}
