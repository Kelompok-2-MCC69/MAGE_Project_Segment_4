package Kelompok2.ProjectKPI.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KPIRequest {

    private Long id;
    private String created_at;
    private String first_deadline;
    private String second_deadline;
    private Long final_score;
    private Integer year;
    private Long employeeId;
    private Long managerId;
}
