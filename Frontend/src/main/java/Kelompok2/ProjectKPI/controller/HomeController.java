package Kelompok2.ProjectKPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/dashboard")
    public String dashboard(Model model){
        model.addAttribute("name", "Hallo Arie Tampan");
        return "dashboard/home";
    }
}
