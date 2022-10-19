package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private String phone;

    private Genders genders;

    private Long salary;

    // Manager - Employee Relation
    @ManyToOne
    private Employee manager;

    // User - Employee Relation
    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    // Department - Employees Relation
    @ManyToOne
    private Department department;

    // Department - Manager Relation
    @OneToMany(mappedBy = "manager")
    private List<Department> m_department;

    // Job - Employee Relation
    @ManyToOne
    private Job job;

    // KPI - Employee Relation
    @OneToMany(mappedBy = "employee")
    private List<KPI> e_kpi;

    // KPI - Manager Relation
    @OneToMany(mappedBy = "manager")
    private List<KPI> m_kpi;
}