package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.Status;
import Kelompok2.ProjectKPI.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/status")
public class StatusController {

    private StatusService statusService;

    public List<Status> getAll(){
        return statusService.getAll();
    }

    @GetMapping("/{id}")
    public Status getById(@PathVariable Long id){
        return statusService.getById(id);
    }

    @PostMapping
    public Status create(@RequestBody Status status){
        return statusService.create(status);
    }

    @PutMapping("/{id}")
    public Status update(@RequestBody Status status, @PathVariable Long id){
        return statusService.update(status,id);
    }

    @DeleteMapping("/{id}")
    public Status delete(@PathVariable Long id){
        return statusService.delete(id);
    }
}
