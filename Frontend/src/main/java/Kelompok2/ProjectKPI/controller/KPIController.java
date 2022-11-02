package Kelompok2.ProjectKPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import Kelompok2.ProjectKPI.service.KPIService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/kpi")
@AllArgsConstructor
public class KPIController {

    private KPIService kpiService;

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("kpis", kpiService.getAll());
        model.addAttribute("isActive", "kpi");
        return "kpi/kpi";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        kpiService.delete(id);
        return "redirect:/kpi";
    }

    @GetMapping("/mykpi")
    public String getMyKpi(Model model){
        model.addAttribute("isActive", "mykpi");
        model.addAttribute("mykpis", kpiService.getMyKPI(2L));
        return "mykpi/mykpi";
    }
    
}
