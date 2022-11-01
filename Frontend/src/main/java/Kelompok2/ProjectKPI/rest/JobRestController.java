package Kelompok2.ProjectKPI.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id) {
        return jobService.getById(id);
    }

    @PostMapping
    public Job create(@RequestBody Job job){
        return jobService.create(job);
    }

    @PutMapping("/{id}")
    public Job update(@RequestBody Job job,@PathVariable Long id){
        return jobService.update(job,id);
    }

    @DeleteMapping("/{id}")
    public Job delete(@PathVariable Long id){
        return jobService.delete(id);
    }
}
