package Kelompok2.ProjectKPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Kelompok2.ProjectKPI.service.JobService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/job")
public class JobController {
    
    private JobService jobService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("jobs", jobService.getAll());
        model.addAttribute("isActive", "job");
        return "job/job";
    }
}
