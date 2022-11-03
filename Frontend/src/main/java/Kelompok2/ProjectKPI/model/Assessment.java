package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Assessment {
    
    private Long id;
    private String indicator;
    private Integer weight;
    private String kpiRating;
    private String e_comment;
    private Integer e_rating;
    private String m_comment;
    private Integer m_rating;
    private Integer score;
    private KPI kpi;
}
