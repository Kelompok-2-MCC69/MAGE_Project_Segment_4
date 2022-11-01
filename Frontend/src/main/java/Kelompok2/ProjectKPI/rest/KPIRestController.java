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

import Kelompok2.ProjectKPI.model.KPI;
import Kelompok2.ProjectKPI.model.dto.request.KpiRequest;
import Kelompok2.ProjectKPI.service.KPIService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/kpi")
public class KPIRestController {
    
    private KPIService kpiService; 

    @GetMapping
    public List<KPI> getAll(){
        return kpiService.getAll();
    }

    @GetMapping("/{id}")
    public KPI getById(@PathVariable Long id) {
        return kpiService.getById(id);
    }

    @PostMapping
    public KPI create(@RequestBody KPI kpi){
        return kpiService.create(kpi);
    }

    @PutMapping("/{id}")
    public KPI update(@RequestBody KpiRequest kpiRequest,@PathVariable Long id){
        return kpiService.update(kpiRequest,id);
    }

    @DeleteMapping("/{id}")
    public KPI delete(@PathVariable Long id){
        return kpiService.delete(id);
    }

    @GetMapping("/mykpi/{id}")
    public List<KPI> getMyKpi(@PathVariable Long id){
        // return kpiService.getMyKPI(1L);
        return kpiService.getMyKPI(id);
    }

}
