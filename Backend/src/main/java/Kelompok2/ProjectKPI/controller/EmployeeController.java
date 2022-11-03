package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Employee;
import Kelompok2.ProjectKPI.model.Job;
import Kelompok2.ProjectKPI.model.dto.request.EmployeeRequest;
import Kelompok2.ProjectKPI.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.getById(id);
    }

    @PostMapping
    public Employee create(@RequestBody EmployeeRequest employeeRequest){
        return employeeService.create(employeeRequest);
    }

    @PutMapping("/{id}")
    public Employee update(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long id){
        return employeeService.update(employeeRequest,id);
    }

    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable Long id){
        return employeeService.delete(id);
    }

    @PostMapping("/manager/{id}")
    public Employee addManager(@RequestBody Employee employee,@PathVariable Long id){
        return employeeService.addManager(employee,id);
    }

    @PostMapping("/job/{id}")
    public Employee addJob(@RequestBody Job job, @PathVariable Long id){
        return employeeService.addJob(job,id);
    }

}
