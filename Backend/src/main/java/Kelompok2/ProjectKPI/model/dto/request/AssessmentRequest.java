package Kelompok2.ProjectKPI.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentRequest {

    private String indicator;
    private Integer weight;
    private String kpiRating;
    private Long kpiId;
}
