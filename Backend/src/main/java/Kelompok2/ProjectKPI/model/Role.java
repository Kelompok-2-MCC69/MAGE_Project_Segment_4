package Kelompok2.ProjectKPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    private Long id;
    @Column(nullable = false)
    private String name;
}
