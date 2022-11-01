package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Department;
import Kelompok2.ProjectKPI.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public List<Department> getAll(){
        return departmentRepository.findAll();
    }

    public Department getById(Long id){
        return departmentRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Department is Not Found"));
    }

    public Department create(Department department) {
        if (department.getId() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Department is Already Exist");
        }
        if (departmentRepository.findByName(department.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Department is Already Exist");
        }
        return departmentRepository.save(department);
    }

    public Department update(Department department,Long id){
        getById(id);
        department.setId(id);
        return departmentRepository.save(department);
    }

    public Department delete(Long id){
        Department department = getById(id);
        departmentRepository.delete(department);
        return department;
    }

}
