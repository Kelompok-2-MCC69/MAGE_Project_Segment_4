package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String phone;

    private enum gender {MALE, FEMALE}

    private Long salary;

    // Manager - Employee Relation
    @ManyToOne
    private Employee manager;

    // User - Employee Relation
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    // Job - Employees Relation
    @ManyToOne
    private Job job;

    // Department - Employees Relation
    @ManyToOne
    private Department department;

}