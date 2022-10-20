/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelompok2.ProjectKPI.services;

import Kelompok2.ProjectKPI.model.Department;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author ASUS
 */
@AllArgsConstructor
@Service
public class DepartementService {
    
    private DepartmentRepository departmentRepository;
    
    
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
    
    public Departement getById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.CONFLICT,"Department Already Exists, Sorry!"));
    }
    
    public Department create(Department department) {
        if(department.getId()!=null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Department Already Exists, Sorry!");
        }
        if(departmentRepository.findByName(region.getName()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Department Name Already Exists, Sorry!");
        }
        
        return departmentRepository.save(department);
    }
    
    public Department update(Department department, Long id) {
        getById(id);
        department.setId(id);
        return departmentRepository.save(department);
    }
    
    public Department delete(Long id) {
        Department department = getById(id);
        departmentRepository.delete(department);
        return department;
    }
}
