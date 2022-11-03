package Kelompok2.ProjectKPI.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Kelompok2.ProjectKPI.model.dto.request.AssessmentRequest;
import Kelompok2.ProjectKPI.service.AssessmentService;
import Kelompok2.ProjectKPI.service.KPIService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/assessment")
@AllArgsConstructor
public class AssessmentController {
    
    private AssessmentService assessmentService;
    private KPIService kpiService;

    @GetMapping("/{id}")
    public String getByKPI(Model model, @PathVariable Long id){
        model.addAttribute("kpi", kpiService.getById(id));
        model.addAttribute("assessments", assessmentService.getByKPI(id));
        model.addAttribute("score", assessmentService.sumScore(id));
        return "assessment/assessment";
    }

    @GetMapping("/create/{id}")
    public String createAssessment(Model model,@PathVariable Long id){
        model.addAttribute("kpi", kpiService.getById(id));
        model.addAttribute("assessmentRequest", new AssessmentRequest());
        return "assessment/createAss";
    }

    @PostMapping
    public String saveAssessment(AssessmentRequest assessmentRequest){
        assessmentService.create(assessmentRequest);
        return "redirect:/kpi";
    }

    @GetMapping("/edit/{id}")
    public String beforeUpdate(Model model, @PathVariable Long id){
        model.addAttribute("assessment", assessmentService.getById(id));
        return "assessment/updateAss";
    }

    @PutMapping("/edit/{id}")
    public String updated(AssessmentRequest assessmentRequest, @PathVariable Long id){
        assessmentService.update(assessmentRequest, id);
        return "redirect:/kpi";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        assessmentService.delete(id);
        return "redirect:/kpi";
    }

    @GetMapping("/myass/{id}")
    public String getByKPIEmp(Model model, @PathVariable Long id, Authentication authentication){
        model.addAttribute("name", authentication.getName());
        model.addAttribute("kpi", kpiService.getById(id));
        model.addAttribute("assessments", assessmentService.getByKPI(id));
        model.addAttribute("score", assessmentService.sumScore(id));
        return "assessment/assessmentEmp";
    }


    @GetMapping("/edit/myass/{id}")
    public String beforeUpdateEmp(Model model, @PathVariable Long id,Authentication authentication){
        model.addAttribute("name", authentication.getName());
        model.addAttribute("assessment", assessmentService.getById(id));
        return "assessment/updateAssEmp";
    }

    @PutMapping("/myass/{id}")
    public String updatedEmp(AssessmentRequest assessmentRequest, @PathVariable Long id){
        assessmentService.update(assessmentRequest, id);
        return "redirect:/dashboard";   
    }
}
