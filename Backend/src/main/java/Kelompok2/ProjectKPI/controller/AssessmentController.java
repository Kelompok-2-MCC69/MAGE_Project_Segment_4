package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.model.dto.request.AssessmentRequest;
import Kelompok2.ProjectKPI.service.AssessmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.mail.MessagingException;

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
    public Assessment create(@RequestBody AssessmentRequest assessmentRequest) throws MessagingException{
        return assessmentService.create(assessmentRequest);
    }

    @PutMapping("/{id}")
    public Assessment update(@RequestBody AssessmentRequest assessmentRequest, @PathVariable Long id){
        return assessmentService.update(assessmentRequest,id);
    }

    @DeleteMapping("/{id}")
    public Assessment delete(@PathVariable Long id){
        return assessmentService.delete(id);
    }

    @GetMapping("/kpi/{id}")
    public List<Assessment> getByKPI(@PathVariable Long id){
        return assessmentService.getByKPI(id);
    }

    @GetMapping("/sum/{id}")
    public Integer sumScore(@PathVariable Long id){
        return assessmentService.sumScore(id);
    }
}
