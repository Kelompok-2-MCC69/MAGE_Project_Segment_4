package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String phone;
    private Long salary;
    private String gender;
    private Employee manager;
    private User user;
    private Role role;
    private Department department;
    private Job job;
}
