package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KPI {
    
    private Long id;
    private String created_at;
    private String first_deadline;
    private String second_deadline;
    private Long final_score;
    private Integer year;
    private Employee employee;
    private Employee manager;
    private Long employeeId;
    private Long managerId;
}
