package Kelompok2.ProjectKPI.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kelompok2.ProjectKPI.model.Job;
import Kelompok2.ProjectKPI.service.JobService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/job")
public class JobRestController {
    
    private JobService jobService;

    @GetMapping
    public List<Job> getAll(){
        return jobService.getAll();
    }
}
