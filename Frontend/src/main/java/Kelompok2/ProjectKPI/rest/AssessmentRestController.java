package Kelompok2.ProjectKPI.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.service.AssessmentService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/assessment")
public class AssessmentRestController {
    
    private AssessmentService assessmentService;

    @GetMapping
    public List<Assessment> getAll(){
        return assessmentService.getAll();
    }

    // @GetMapping("/kpi/{id}")
    // public List<Assessment> getByKPI(Long id){
    //     return assessmentService.getByKPI(id);
    // }
}
