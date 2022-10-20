/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Department;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@AllArgsConstructor
@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    private DepartmentService departmentService;
    
    @GetMapping("/{id}")
    public List<Department>getAll() {
        return departmentService.getAll();
    }
    
    @PostMapping
    public Department create(@RequestBody Department department) {
        return departmentService.create(department);
    }
    
    @PutMapping("/{id}")
    public department update(@RequestBody Department department, @PathVariable Long id) {
        return departmentService.update(department, id);
    }
    
    @DeleteMapping("/{id}")
    public Department delete(@PathVariable Long id) {
        return departmentService.delete(id);
    }
}
