package Kelompok2.ProjectKPI.service;

import Kelompok2.ProjectKPI.model.Assessment;
import Kelompok2.ProjectKPI.model.KPI;
import Kelompok2.ProjectKPI.model.dto.request.AssessmentRequest;
import Kelompok2.ProjectKPI.repository.AssessmentsRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AssessmentService {

    private ModelMapper modelMapper;
    private KPIService kpiService;
    private AssessmentsRepository assessmentsRepository;

    public List<Assessment> getAll(){
        return assessmentsRepository.findAll();
    }

    public Assessment getById(Long id){
        return assessmentsRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Assessment is Not Found"));
    }

    public List<Assessment> getByKPI(Long id){
        return assessmentsRepository.getByKPI(id);
    }

    public Assessment create(AssessmentRequest assessmentRequest){
        Assessment assessment = modelMapper.map(assessmentRequest,Assessment.class);
        assessment.setKpi(kpiService.getById(assessmentRequest.getKpiId()));
        return assessmentsRepository.save(assessment);
    }

    public Assessment update(AssessmentRequest assessmentRequest, Long id){
        Assessment assessment = modelMapper.map(assessmentRequest,Assessment.class);
        getById(id);
        assessment.setId(id);
        assessment.setKpi(kpiService.getById(assessmentRequest.getKpiId()));
        return assessmentsRepository.save(assessment);
    }

    public Assessment delete(Long id){
        Assessment assessment = getById(id);
        assessmentsRepository.delete(assessment);
        return assessment;
    }

    public Integer sumScore(Long id){
        return assessmentsRepository.sumScore(id);
    }

}

