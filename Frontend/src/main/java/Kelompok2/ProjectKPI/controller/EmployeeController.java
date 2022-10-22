package Kelompok2.ProjectKPI.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Kelompok2.ProjectKPI.service.EmployeeService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    
    private EmployeeService employeeService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("isActive", "employee");
        model.addAttribute("employees", employeeService.getAll());
        return "employee/employee";
    }

}
