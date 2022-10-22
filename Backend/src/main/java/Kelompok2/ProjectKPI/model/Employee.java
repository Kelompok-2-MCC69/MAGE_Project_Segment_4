package Kelompok2.ProjectKPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false,unique = true,length = 13)
    private String phone;

    @Column(nullable = false)
    private Long salary;

    @Enumerated
    @Column(nullable = false)
    private Gender gender;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "manager")
    private List<Department> m_department;

    // Job - Employee Relation
    @ManyToOne
    private Job job;

    // KPI - Employee Relation
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "employee")
    private List<KPI> e_kpi;

    // KPI - Manager Relation
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "manager")
    private List<KPI> m_kpi;
}