package Kelompok2.ProjectKPI.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Kelompok2.ProjectKPI.service.AssessmentService;
import Kelompok2.ProjectKPI.service.KPIService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/assessment")
@AllArgsConstructor
public class AssessmentController {
    
    private AssessmentService assessmentService;
    private KPIService kpiService;

    @GetMapping
    public String getByKPI(Model model){
        model.addAttribute("kpi", kpiService.getById(1L));
        model.addAttribute("assessments", assessmentService.getByKPI(1L));
        // model.addAttribute("kpi", kpiService.getById(id));
        // model.addAttribute("assessments", assessmentService.getByKPI(id));
        return "assessment/assessment";
    }

    // @GetMapping
    // public String getByKPI(Model model, Long id){
    //     model.addAttribute("kpi", assessmentService.getByKPI(id));
    //     return "assessment/assessment";
    // }

}
