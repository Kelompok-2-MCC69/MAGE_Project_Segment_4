/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Kelompok2.ProjectKPI.controller;

import Kelompok2.ProjectKPI.model.KPI;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author ASUS
 */
public class KPIController {
    
    private KPIService  kpiService;
    
    @GetMapping
    public List<KPI> getAll() {
        return kpiService.getAll();
    }
    
    @GetMapping("/{id}")
    public KPI getById(@PathVariable Long id) {
        return kpiService.getById(id);
    }
    
    @PostMapping
    public KPI create(@RequestBody KPI kpi) {
        return kpiService.create(kpi);
    }
    
    @PutMapping ("/{id}")
    public KPI update(@RequestBody KPI kpi, @PathVariable Long id) {
        return kpiService.update(kpi, id);
    }
    
    @DeleteMapping("/{id}")
    public KPI delete(@PathVariable Long id) {
        return kpiService.delete(id);
    }
    
    
}
