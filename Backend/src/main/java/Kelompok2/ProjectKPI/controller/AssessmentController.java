package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.model.dto.request.AssessmentRequest;
import Kelompok2.ProjectKPI.service.AssessmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/assessment")
public class AssessmentController {

    private AssessmentService assessmentService;

    @GetMapping
    public List<Assessment> getAll(){
        return assessmentService.getAll();
    }

    @GetMapping("/{id}")
    public Assessment getById(@PathVariable Long id){
        return assessmentService.getById(id);
    }

    @PostMapping
    public Assessment create(@RequestBody AssessmentRequest assessmentRequest){
        return assessmentService.create(assessmentRequest);
    }

    @PutMapping("/{id}")
    public Assessment update(@RequestBody Assessment assessment, @PathVariable Long id){
        return assessmentService.update(assessment,id);
    }

    @DeleteMapping("/{id}")
    public Assessment delete(@PathVariable Long id){
        return assessmentService.delete(id);
    }

    @GetMapping("/kpi/{id}")
    public List<Assessment> getByKPI(@PathVariable Long id){
        return assessmentService.getByKPI(id);
    }
}
