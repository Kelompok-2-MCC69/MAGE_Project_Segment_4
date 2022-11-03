package Kelompok2.ProjectKPI.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import Kelompok2.ProjectKPI.service.AssessmentService;
import Kelompok2.ProjectKPI.service.EmployeeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    
    private EmployeeService employeeService;
    private AssessmentService assessmentService;

    @GetMapping
    public String getAll(Model model,Authentication authentication){
        model.addAttribute("name", authentication.getName());
        model.addAttribute("isActive", "employee");
        model.addAttribute("employees", employeeService.getAll());
        return "employee/employee";
    }

    // @GetMapping("/{id}")
    // public String getById(Model model,@PathVariable Long id){
    //     model.addAttribute("employee", employeeService.getById(id));
    //     return "employee/employeeKpi";
    // }

}
