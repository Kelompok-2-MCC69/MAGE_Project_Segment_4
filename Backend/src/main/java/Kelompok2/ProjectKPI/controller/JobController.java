package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Job;
import Kelompok2.ProjectKPI.service.JobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/job")
public class JobController {

    private JobService jobService;

    @GetMapping
    public List<Job> getAll(){
        return jobService.getAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Long id){
        return jobService.getById(id);
    }

    @PostMapping
    public Job create(@RequestBody Job job){
        return jobService.create(job);
    }

    @PutMapping("/{id}")
    public Job update(@RequestBody Job job, @PathVariable Long id){
        return jobService.update(job,id);
    }

    @DeleteMapping("/{id}")
    public Job delete(@PathVariable Long id){
        return jobService.delete(id);
    }
}
