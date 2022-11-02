//package Kelompok2.ProjectKPI.controller;
//
//import Kelompok2.ProjectKPI.model.KPI;
//import Kelompok2.ProjectKPI.service.KPIService;
//import lombok.AllArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@AllArgsConstructor
//@RequestMapping("/mykpi")
//public class MyKpiController {
//
//    private KPIService kpiService;
//
//    @GetMapping("/{id}")
//    public List<KPI> getMyKpi(@PathVariable Long id){
//        return kpiService.getMyKpi(id);
//    }
//}
