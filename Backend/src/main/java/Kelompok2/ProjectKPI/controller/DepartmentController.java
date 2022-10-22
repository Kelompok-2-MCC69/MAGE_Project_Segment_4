package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Department;
import Kelompok2.ProjectKPI.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll(){
        return departmentService.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id){
        return departmentService.getById(id);
    }

    @PostMapping
    public Department create(@RequestBody Department department){
        return departmentService.create(department);
    }

    @PutMapping("/{id}")
    public Department update(@RequestBody Department department, @PathVariable Long id){
        return departmentService.update(department,id);
    }

    @DeleteMapping("/{id}")
    public Department delete(@PathVariable Long id){
        return departmentService.delete(id);
    }
}
