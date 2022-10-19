package Kelompok2.ProjectKPI.repository;

import Kelompok2.ProjectKPI.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
