package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.KPI;
import Kelompok2.ProjectKPI.service.KPIService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kpi")
@AllArgsConstructor
public class KPIController {

    private KPIService kpiService;

    @GetMapping
    public List<KPI> getAll(){
        return kpiService.getAll();
    }

    @GetMapping("/{id}")
    public KPI getById(@PathVariable Long id){
        return kpiService.getById(id);
    }

    @PostMapping
    public KPI create(@RequestBody KPI kpi){
        return kpiService.create(kpi);
    }

    @PutMapping("/{id}")
    public KPI update(@RequestBody KPI kpi, @PathVariable Long id){
        return kpiService.update(kpi,id);
    }

    @DeleteMapping("/{id}")
    public KPI delete(@PathVariable Long id){
        return kpiService.delete(id);
    }

}
