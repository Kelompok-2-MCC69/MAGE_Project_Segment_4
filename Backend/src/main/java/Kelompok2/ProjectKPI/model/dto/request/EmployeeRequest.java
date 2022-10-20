package Kelompok2.ProjectKPI.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private String name;
    private Integer age;
    private String email;
    private String phone;
    private String genders;
    private Long salary;
    private String username;
    private String password;
}
