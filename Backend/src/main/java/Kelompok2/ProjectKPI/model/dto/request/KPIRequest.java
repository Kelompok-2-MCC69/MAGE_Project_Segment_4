package Kelompok2.ProjectKPI.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KPIRequest {

    private Long employeeId;
    private Long managerId;
}
